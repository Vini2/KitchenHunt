(function () {
    var input = document.getElementById("images"),
            formdata = false;

    function showUploadedItem(source) {
        
        var list = document.getElementById("image-list"),
                li = document.createElement("li"),
                img = document.createElement("img");
        img.src = source;
        li.appendChild(img);
        list.appendChild(li);
        
//        document.getElementById("image-list").innerHTML = "<li><img src="+source+"></li>";
        document.getElementById("btn-clear-div").innerHTML = "<button class='btn btn-success' type='button' id='btn-clear' onclick=removeImage()>Clear Images</button>";
        
    }

    if (window.FormData) {
        formdata = new FormData();
        document.getElementById("btn").style.display = "none";
    }

    input.addEventListener("change", function (evt) {

        var i = 0, len = this.files.length, img, reader, file;

        for (; i < len; i++) {
            file = this.files[i];

            if (!!file.type.match(/image.*/)) {
                if (window.FileReader) {
                    reader = new FileReader();
                    reader.onloadend = function (e) {
                        
                        showUploadedItem(e.target.result, file.fileName);
                    };
                    reader.readAsDataURL(file);
                }
            }
        }

    }, false);
}());

function removeImage() {

//    var oldInput = document.getElementById("images");
//
//    var newInput = document.createElement("input");
//
//    newInput.type = "file";
//    newInput.id = "images";
//    newInput.name = oldInput.name;
//    newInput.className = oldInput.className;
//
//    oldInput.parentNode.replaceChild(newInput, oldInput);

    document.getElementById("images").value = "";
    document.getElementById("image-list").innerHTML = "";
    document.getElementById("btn-clear-div").innerHTML = "";
}