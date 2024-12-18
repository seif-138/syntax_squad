package com.example.myapp.rest;

import com.example.myapp.Service.Cart.CartService;
import com.example.myapp.Service.Courses.CoursesService;
import com.example.myapp.Service.Instructor.InstructorService;
import com.example.myapp.Service.Payment.PaymentService;
import com.example.myapp.Service.Student.StudentService;
import com.example.myapp.Service.Student_course.Student_courseService;
import com.example.myapp.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class home {
    private StudentService studentService;
    private InstructorService instructorService;
    private Student_courseService studentCourseService;
    private CartService cartService;
    private CoursesService coursesService;
    private PaymentService paymentService;

    private int U_id;

//    public home(StudentService studentService, InstructorService instructorService, Student_courseService studentCourseService, CartService cartService, CoursesService coursesService) {
//        this.studentService = studentService;
//        this.instructorService = instructorService;
//        this.studentCourseService = studentCourseService;
//        this.cartService = cartService;
//        this.coursesService = coursesService;
//    }


    public home(StudentService studentService, InstructorService instructorService, Student_courseService studentCourseService, CartService cartService, CoursesService coursesService, PaymentService paymentService) {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.studentCourseService = studentCourseService;
        this.cartService = cartService;
        this.coursesService = coursesService;
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/register")
    public String signup(@RequestParam("fname") String fn, @RequestParam("lname") String ln, @RequestParam("email") String e, @RequestParam("uname") String u, @RequestParam("password") String pass) {
        Student s = new Student(fn, ln, u, pass, e);
       Student x= studentService.save(s);
        U_id = x.getStudent_id();
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@RequestParam("logmail") String l, @RequestParam("logpass") String p, @RequestParam("user_type") String user) {
        if (user.equals("student")) {
            Student s = studentService.findByEmail(l);
            if (s == null) {
                System.out.println("No account with this email ");
            } else {
                if (s.getPassword().equals(p)) {
                    System.out.println("Password is correct");
                    U_id = s.getStudent_id();
                    return "redirect:/home";
                } else {
                    System.out.println("password is incorrect");
                }
            }
            return "index";
        } else {
            Instructor i = instructorService.findByEmail(l);
            System.out.println(i);
            if (i == null) {
                System.out.println("No account with this email ");
            } else {
                if (i.getPass().equals(p)) {
                    System.out.println("Password is correct");
                    return "redirect:/home";
                } else {
                    System.out.println("password is incorrect");
                }
            }
            return "index";
        }
    }

    //    @GetMapping("/home")
//    public String homePage(){
//        return "home";
//    }
    @GetMapping("/home")
    public String homePageDetails(Model model) {
        Student s = studentService.findById(U_id);

        List<Courses> sc = studentCourseService.findStudentCourses(U_id);
        List<Courses> not = studentCourseService.findStudentNotEnrolledCourses(sc);
        System.out.println(not);
        model.addAttribute("courses", sc);
        model.addAttribute("notE", not);
        return "home";
    }

    @GetMapping("/cart/{id}")
    public String cart(@PathVariable int id) {
        List<Cart> cAs = cartService.findByCourseIdAndStudentId(U_id, id);
        if (cAs.isEmpty()||cAs==null) {
            Cart c = new Cart(U_id, id);
            cartService.addItem(c);
        }


        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cartI(Model model) {
        List<Courses> sc = cartService.findItems(U_id);
        double total = 0;
        for (Courses c : sc) {
            total += c.getPrice();
        }
        System.out.println(sc);
        model.addAttribute("cartItems", sc);
        model.addAttribute("total", total);
        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteCartitem(@PathVariable int id) {
        cartService.deleteByStudentAndCourseId(U_id,id);
        return "redirect:/cart";
    }
    int tmpid;

    @GetMapping("/details/{id}")
    public String details(@PathVariable int id) {
        Courses c = coursesService.findById(id);
        tmpid = id;

        return "redirect:/details/";
    }

    @GetMapping("/details/")
    public String detailsPage(Model model) {
        Courses c = coursesService.findById(tmpid);
        model.addAttribute("courseDetails", c);

        return "course-details";
    }

    @GetMapping("/payment")
    public String pay() {
        return "payment";
    }

    @PostMapping("/payment/check")
    public String checkPayment(Model model, @RequestParam("cardName") String email, @RequestParam("cardNumber") int cardNum) {

        Student s = studentService.findByEmail(email);
        System.out.println("\n---------\ncardNum:" + cardNum);
        System.out.println(cardNum + 1);
        if (s.getPaymentCard() == cardNum) {
            System.out.println("Payment processed successfully!");
            List<Cart> cart = cartService.findByStudentId(s.getStudent_id());
            List<student_courses> coursesincart = studentCourseService.enrollCoursesFromCart(cart);
            for(Cart i:cart){
                Payment p=new Payment();
                p.setCourse_id(i.getCourse_id());
                p.setStudent_id(i.getStudent_id());
                p.setPayment_date(LocalDate.now());
                paymentService.add(p);
            }
            cartService.deleteListOfCartItems(cart);


        } else {
            System.out.println("Payment failed. Please try again.");
        }


        return "redirect:/home";
    }

}
