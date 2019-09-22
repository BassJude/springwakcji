<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--Znacznik <sf:form> generuje znacznik HTML <form> . Tworzy też pewien kontekst--%>
<%--    wokół obiektu modelu przekazywany przez atrybut commandName . Właściwości obiektu--%>
<%--    modelu będą się odwoływać w innych wykorzystywanych znacznikach wiązania danych.--%>
<%--    W poniższym kodzie wartość atrybutu commandName ustawiamy na spitter . W modelu--%>
<%--    musi więc istnieć obiekt, którego kluczem jest spitter , w przeciwnym wypadku nie uda--%>
<%--    się nam wygenerować formularza (i otrzymamy błąd JSP). Oznacza to, że musimy--%>
<%--    wykonać niewielką modyfikację kontrolera SpitterController , aby obiekt Spitter został--%>
<%--    zapisany w modelu pod kluczem spitter :--%>
<%--    @RequestMapping(value="/register", method=GET)--%>
<%--    public String showRegistrationForm(Model model) {--%>
<%--    model.addAttribute(new Spitter());--%>
<%--    return "registerForm";--%>
<%--    }--%>

<sf:form method="POST" commandName="spitter">
    <sf:errors path="*" element="div" cssClass="errors" />

    <sf:label path="firstName" cssErrorClass="error">Imię</sf:label>:
    <sf:input path="firstName" cssErrorClass="error" /><br/>
    <%--    errory--%>
    <sf:errors path="firstName" /><br/>
    Nazwisko: <sf:input path="lastName" /><br/>
<%--    Warto zaznaczyć, że poczynając od Springa 3.1, znacznik <sf:input> umożliwia okre---%>
<%--    ślenie wartości atrybutu type , pozwalającej na deklarację typów tekstowych specyficz---%>
<%--    nych dla HTML 5, takich jak data , range czy email .--%>
    Adres e-mail: <sf:input path="email" type="email" /><br/>
    Nazwa użytkownika: <sf:input path="username" /><br/>
    Hasło: <sf:password path="password" /><br/>
    <input type="submit" value="Zarejestruj" />
</sf:form>

<%--Wracając do formularza — jego pierwsze trzy pola zostały zamienione ze znacz---%>
<%--ników <input> na <sf:input> . Znacznik ten generuje kod znacznika HTML <input>--%>
<%--    z atrybutem type ustawionym na text . Jego atrybut value przyjmuje wartość właściwości--%>
<%--    obiektu modelu określonej w atrybucie path . Na przykład jeśli w obiekcie klasy Spitter--%>
<%--    wartością właściwości firstName jest Jack , to znacznik <sf:input path="firstName"/>--%>
<%--    zostanie wygenerowany jako znacznik <input> z wartością atrybutu value="Jack" .--%>



</body>
</html>
