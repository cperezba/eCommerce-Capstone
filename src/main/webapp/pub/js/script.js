function myFunction() {
    document.getElementById("dropdown").classList.toggle("show");
}

window.onclick = function (event) {
    console.log(event.target);
    if (!event.target.matches(".dropdown-btn")) {
        let dropdowns = document.getElementsByClassName("dropdown-content");
        for (let i = 0; i < dropdowns.length; i++) {
            let openDropdown = dropdowns[i];
            if (openDropdown.classList.contains("show")) {
                openDropdown.classList.remove("show");

            }
        }
    }
};


console.log(event.onclick.target)