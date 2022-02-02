<%-- 
    Document   : editnote
    Created on : Jan 30, 2022, 8:36:22 PM
    Author     : Gao Liu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note" method="post">
            <label for="title"><b>Title:</b></label>
            <input type="text" name="title" id="title" value="${note.title}">
            <br>
            <label for="contents"><b>Contents:</b></label>
            <textarea name="contents" id="contents" rows="4" cols="20">${note.contents}</textarea>
            <br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>
