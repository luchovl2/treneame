function handleClick()
{
    fetch("/v1/treneame/lineas", {method: 'GET'}).then((res)=>{
        if(res.ok)
        {
            return res.json();
        }
        console.log("Request failed");
    }).then((res)=>{
        lista = document.getElementById("lista_lineas");

        res.forEach((elem) => {
            item = document.createElement("li");
//            item.innerText = elem.name;
            item.setAttribute("id", "linea" + elem.id);

            boton = document.createElement("button");
            boton.innerText = elem.name;
            item.appendChild(boton);
            boton.addEventListener('click', (e)=>{
                onLineaClick(elem);

                e.target.removeEventListener('click', arguments.callee);
            });

            lista.appendChild(item);
        });

        console.log(res);
    });
}

function onLineaClick(linea){
//    alert("linea " + elem.name + " with id " + elem.id);
    uri = "/v1/treneame/linea/" + linea.id + "/estaciones";

    fetch(uri, {method: 'GET'}).then((res)=>{
        if(res.ok)
        {
            return res.json();
        }
        console.log("Request failed");
    }).then((res)=>{
        //crea una lista para las estaciones de esta linea
        lineaLista = document.createElement("ul");

        //agrega la lista de estaciones al item de la linea
        lineaItem = document.getElementById("linea" + linea.id);
        lineaItem.appendChild(lineaLista);

        res.forEach((elem) => {
            //agrega cada estación a la lista
            item = document.createElement("li");
            item.innerText = elem.name;
            item.addEventListener('click', ()=>{
                onEstacionClick(linea.id, elem);
            });

            lineaLista.appendChild(item);
        });

        console.log(res);
    });
}

function onEstacionClick(lineaId, estacion)
{
//    alert(window.location.host);
//    alert("/linea/" + lineaId + "/" + estacion.id);

    window.location.href = window.location.href + "/linea/" + lineaId + "/" + estacion.id;
}