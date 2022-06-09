window.onload = function() {
    console.log('The page loaded!');
    let button = document.getElementById('login-button');
    button.addEventListener('click', login);

    let passwordField = document.getElementById('login-password');
    passwordField.addEventListener('keyup', function(e) {
        if (e.key === 'Enter') {
            login();
        }
    });
}

function login() {

    // Convenience references
    let usernameInput = document.getElementById('login-username');
    let passwordInput = document.getElementById('login-password');
  
    
    let username = usernameInput.value;
    let pswd = passwordInput.value;

    if (username && pswd) {
        
        // If the error message is being displayed, hide it
     

        let respData = fetch('http://localhost:8080/bankingApp/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username, pswd})
        }).then(resp => {
            console.log(`Response status: ${resp.status}`);
            console.log(`Response timestamp: ${Date.now()}`);

         
       
        })
        
   

}
}