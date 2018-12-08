<%@include file="include/part/head.jsp"%>
<%@include file="include/part/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>CKEditor 5 – Classic editor</title>
    <script src="ckeditor.js"></script>
</head>
<body>
    <h1>Classic editor</h1>
    <textarea name="content" id="editor">
        &lt;p&gt;This is some sample content.&lt;/p&gt;
    </textarea>
    <script>
        ClassicEditor
            .create( document.querySelector( '#editor' ) )
            .catch( error => {
                console.error( error );
            } );
    </script>
</body>
</html>