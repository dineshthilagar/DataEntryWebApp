// Function to save user data to the file
function saveData() {
    const userData = document.getElementById("userData").value;

    // Validate if user data is not empty
    if (userData.trim() === "") {
        alert("Please enter data before saving.");
        return;
    }

    // Make an AJAX request to the server to save data
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/saveData", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("userData=" + encodeURIComponent(userData));

    // Reset the input field
    document.getElementById("userData").value = "";
}

// Function to reset the input field
function resetData() {
    document.getElementById("userData").value = "";
}

// Function to refresh and display file data
function refreshData() {
    // Make an AJAX request to the server to get file data
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("fileData").value = xhr.responseText;
        }
    };
    xhr.open("GET", "/getFileData", true);
    xhr.send();
}
