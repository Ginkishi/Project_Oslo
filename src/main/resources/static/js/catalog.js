const buttons = document.querySelectorAll("span");

buttons.forEach(b => {
    b.addEventListener("click", (e) => {
        if (b == e.target) {
            findService(e);
            let target = e.target;
            let ul = target.querySelector("ul");
            if (target.parentNode.classList.contains("leaf")) {

                return;
            }
            if (ul == null) {
                target.parentNode.classList.toggle("hide");
                let i = target.querySelector("i");
                i.classList.toggle("bxs-folder");
                i.classList.toggle("bxs-folder-open");
                let parent = target.parentNode;
                let cat_id = parent.getAttribute("cat_id");
                fetch("/child/" + cat_id).then(result => {
                    return result.json();
                }).then(data => {
                    if (data.length <= 0) {
                        console.log("vide")
                    } else {
                        target.appendChild(genereTree(data));
                    }
                })
            } else {
                target.parentNode.classList.toggle("hide");
                let i = target.querySelector("i");
                i.classList.toggle("bxs-folder");
                i.classList.toggle("bxs-folder-open");
            }
        }
    })
});
function genereTree(child) {
    let ul = document.createElement("ul");
    console.log(child);
    child.forEach(c => {
        let li = document.createElement("li");
        let a = document.createElement("div");
        let span = document.createElement("span");
        let i = document.createElement("i");
        a.setAttribute("cat_id", c.id);
        let text = document.createTextNode(" " + c.libelle);
        i.classList.add("bx");
        if (c.leaf) {
            a.classList.add("leaf");
            i.classList.add("bxs-circle");
            span.addEventListener("click", findService);
        } else {
            a.classList.add("branch");
            a.classList.add("hide");
            i.classList.add("bxs-folder");
            span.addEventListener("click", subTree);
        }
        span.appendChild(i);
        span.appendChild(text);
        a.appendChild(span);
        li.appendChild(a);
        ul.appendChild(li);
    });
    return ul;
}

function subTree(element) {
    findService(element);
    let el = element.target;
    if (el.parentNode.classList.contains("branch")) {
        let i = el.querySelector("i");
        i.classList.toggle("bxs-folder");
        i.classList.toggle("bxs-folder-open");
        //el = el.parentNode;
        let ul = el.querySelector("ul");
        if (ul == null) {
            el.parentNode.classList.toggle("hide");
            let parent = el.parentNode;
            let cat_id = parent.getAttribute("cat_id");
            fetch("/child/" + cat_id).then(result => {
                return result.json();
            }).then(data => {
                if (data.length <= 0) {
                    console.log("salut")
                } else {
                    el.appendChild(genereTree(data));
                }
            })
        } else {
            el.parentNode.classList.toggle("hide");
        }
    }

    element.stopPropagation();
}
function findService(element) {
    let parent = element.target.parentNode;
    let container = document.querySelector("#services");
    //if (parent.classList.contains("leaf")) {

    fetch("/catalogue/services/" + parent.getAttribute("cat_id")).then(result => {
        return result.json();
    }).then(data => {
        if (data.length <= 0) {
            if (parent.classList.contains("leaf")) {
                container.innerHTML = "Aucun service trouvé";
            }
        } else {
            container.innerHTML = "";
            data.forEach(d => {
                let card = document.createElement("a");
                card.classList.add("card");
                let logo = document.createElement("div");
                logo.classList.add("logo");
                let title = document.createElement("div");
                title.classList.add("title");
                let text = document.createTextNode(d.libelle);
                title.appendChild(text);
                let img = document.createElement("img");
                if (d.image == "null") {
                    img.setAttribute("src", "static/img/data_collecting_monochromatic.svg");
                } else {
                    img.setAttribute("src", "/upload/" + d.image);
                }

                img.setAttribute("alt", "");
                logo.appendChild(img);
                card.setAttribute("href", "/demandeService/createDemandeServiceFromCatalogue?serviceName=" + d.libelle);
                card.appendChild(logo);
                card.appendChild(title);
                container.appendChild(card);
            })
        }
    })
    //}
}