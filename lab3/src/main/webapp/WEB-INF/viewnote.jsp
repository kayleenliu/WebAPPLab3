<%-- 
    Document   : viewnote
    Created on : Jan 30, 2022, 8:36:04 PM
    Author     : Gao Liu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><b>Title: </b>${note.title}</p>
        <p><b>Contents: </b><br>${note.contents}</p>
        <a href="note?edit=true">Edit</a>
    </body>
</html>
