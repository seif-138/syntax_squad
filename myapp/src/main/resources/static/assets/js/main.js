/*=============== SHOW HIDE PASSWORD LOGIN ===============*/
const passwordAccess = (loginPass, loginEye) => {
    const input = document.getElementById(loginPass),
          iconEye = document.getElementById(loginEye);

    iconEye.addEventListener('click', () => {
        // Change password to text
        input.type === 'password' ? input.type = 'text' : input.type = 'password';

        // Icon change
        iconEye.classList.toggle('ri-eye-fill');
        iconEye.classList.toggle('ri-eye-off-fill');
    });
};
passwordAccess('password', 'loginPassword');

/*=============== SHOW HIDE PASSWORD CREATE ACCOUNT ===============*/
const passwordRegister = (loginPass, loginEye) => {
    const input = document.getElementById(loginPass),
          iconEye = document.getElementById(loginEye);

    iconEye.addEventListener('click', () => {
        // Change password to text
        input.type === 'password' ? input.type = 'text' : input.type = 'password';

        // Icon change
        iconEye.classList.toggle('ri-eye-fill');
        iconEye.classList.toggle('ri-eye-off-fill');
    });
};
passwordRegister('passwordCreate', 'loginPasswordCreate');

/*=============== FORGET PASSWORD = ===============*/
const passwordforget = (loginPass, loginEye) => {
    const input = document.getElementById(loginPass),
        iconEye = document.getElementById(loginEye);

    iconEye.addEventListener('click', () => {
        // Change password to text
        input.type === 'password' ? input.type = 'text' : input.type = 'password';

        // Icon change
        iconEye.classList.toggle('ri-eye-fill');
        iconEye.classList.toggle('ri-eye-off-fill');
    });
};
passwordforget('forgetpass', 'loginforgetPassword');

/*=============== SHOW HIDE LOGIN & CREATE ACCOUNT ===============*/
const loginAcessRegister = document.getElementById('loginAccessRegister'),
      buttonRegister = document.getElementById('loginButtonRegister'),
      buttonAccess = document.getElementById('loginButtonAccess');

buttonRegister.addEventListener('click', () => {
    loginAcessRegister.classList.add('active');
});

buttonAccess.addEventListener('click', () => {
    loginAcessRegister.classList.remove('active');
});

/*=============== FORGOT PASSWORD FUNCTIONALITY ===============*/
document.addEventListener("DOMContentLoaded", () => {
    const loginAccessRegister = document.getElementById("loginAccessRegister");
    const forgotPasswordSection = document.querySelector(".login__forgot-password");
    const showForgotPassword = document.getElementById("showForgotPassword");
    const backToLogin = document.getElementById("backToLogin");

    // Show "Forgot Password" section
    showForgotPassword.addEventListener("click", (e) => {
        e.preventDefault();
        loginAccessRegister.style.display = "none";
        forgotPasswordSection.style.display = "block";
    });

    // Back to login
    backToLogin.addEventListener("click", (e) => {
        e.preventDefault();
        forgotPasswordSection.style.display = "none";
        loginAccessRegister.style.display = "grid";
    });

    // Handle "Forgot Password" form submission
    document.querySelector(".login__forgot-password form").addEventListener("submit", (e) => {
        e.preventDefault();

        const email = document.getElementById("forgotEmail").value;

        // Send email to server for reset link
        fetch("/send-reset-link", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ email }),
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert("Reset link sent! Check your email.");
            } else {
                alert("Failed to send reset link. Please try again.");
            }
        })
        .catch(error => {
            console.error("Error:", error);
        });
    });
});
