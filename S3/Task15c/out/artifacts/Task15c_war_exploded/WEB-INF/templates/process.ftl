<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Process</title>
</head>
<body>
    <form name="process" action="/process" method="POST">
        <textarea name="text" type="textarea" <#if text??>value="${text}"</#if>></textarea><br>
        <input name="process" type="submit" value="Process!">
        <select name="operation">
            <option disabled>Выберите операцию</option>
            <option value="symbols-cnt">Количество символов</option>
            <option value="words-cnt">Количество слов</option>
            <option value="sentences-cnt">Количество предложений</option>
            <option value="paragraphs-cnt">Количество абзацев</option>
        </select>
    </form>
</body>
</html>