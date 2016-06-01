function showHint(str) {
    if (str.length == 0) {
        document.getElementById("txtHint").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                var personObj = $.parseJSON(xmlhttp.response);
                var personArray = personObj["personList"];

                var fullName = personArray.map(function(a) {
                    return a.fullName;});

                var list = '';

                for(var i = 0; i < fullName.length; i++){
                    list+= '<hr>' + '<li>' + fullName[i] + '</li>';
                }

                document.getElementById("txtHint").innerHTML = list;
            }
        };
        xmlhttp.open("GET", "/searchPerson?name=" + str, true);
        xmlhttp.send();
    }
}
