function login(){
    
    if(($("#username").val()) === "" || ($("#username").val()) === "") {
        alert("Los campos no deben estar vacios");
        
    } else {

        $.ajax({
            url : "/SambaQuarantine/ServletHandler",
            type: "POST",
            data: { operacion: "login" ,
                username: $("#username").val(),
                password: $("#password").val()
            }
        })
    
                .done(function(data) {
                    if (data === "loged") {
                        window.location.href = "loged.jsp";
            } else {
                alert("Datos incorrectos");
            }
        });
    }
}

function getCuarentena(){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: { operacion: "cuarentena" }
    })            
            .done(function(data) {
                $('#contenido').html(data);
    });
}

function getDisponibles(){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: { operacion: "disponibles" }
    })            
            .done(function(data) {
                $('#contenido').html(data);
    });
}

function logout(){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: { operacion: "logout" }           
    })
            .done(function(data) {
                window.location.href = "/SambaQuarantine";
    });
}

function download(smbPath){

    window.location="/SambaQuarantine/ServletHandler?operacion=download&smbPath="+smbPath;
      
}

function eventLog(){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: {operacion: "eventLog"}           
    })            
            .done(function(data) {
                $('#contenido').html(data);
    });
}

function ownerLog(){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: {operacion: "ownerLog"}           
    })            
            .done(function(data) {
                $('#contenido').html(data);
    });
}

function ViewAntivirusLog(){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: {operacion: "viewAntivirusLog"}           
    })            
            .done(function(data) {
                $('#contenido').html(data);
    });
}

function logRead(file){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: {operacion: "logRead",
            file: file 
        }           
    })            
            .done(function(data) {
                alert(data);
    });
}

function cleanQuarantine(){

    $.ajax({
        url : "/SambaQuarantine/ServletHandler",
        type: "POST",
        data: {operacion: "cleanQuarantine"}           
    })            
            .done(function(data) {
                alert("La Cuarentena se ha limpiado correctamente");
    });
}

$(document).ready(function() {
    
    $(document).validetta;
    
    $('#login').click(function() {
        login();
    });
    $('#cuarentena').click(function() {
        getCuarentena();
    });
    $('#inicio').click(function() {
        window.location.href = "loged.jsp";
    });
    $('#disponibles').click(function() {
        getDisponibles();
    });
    $('#logout').click(function() {
        logout();
    });
    $('#eventLog').click(function() {
        eventLog();
    });
    $('#ownerLog').click(function() {
        ownerLog();
    });
    $('#antivirusLog').click(function() {
        ViewAntivirusLog();
    });
    $('#clean').click(function() {
        cleanQuarantine();
    });
});
