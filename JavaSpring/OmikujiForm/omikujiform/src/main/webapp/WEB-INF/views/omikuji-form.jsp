<!DOCTYPE html>
<html>

<head>
    <title>Omikuji Form</title>
    <link href="https://fonts.googleapis.com/css2?family=Zen+Loop&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/css/omikuji-form.css">
</head>

<body>
    <h1>Omikuji Form</h1>
    <form action="/omikuji/submit" method="post">
        <div>
            <label for="number">Pick any number from 5 to 25:</label>
            <input type="number" id="number" name="number" min="5" max="25" required />
        </div>

        <div>
            <label for="city">Enter the name of any city:</label>
            <input type="text" id="city" name="city" required />
        </div>

        <div>
            <label for="person">Enter the name of any real person:</label>
            <input type="text" id="person" name="person" required />
        </div>

        <div>
            <label for="endeavor">Enter a professional endeavor or hobby:</label>
            <input type="text" id="endeavor" name="endeavor" required />
        </div>

        <div>
            <label for="livingThing">Enter any type of living thing:</label>
            <input type="text" id="livingThing" name="livingThing" required />
        </div>

        <div>
            <label for="niceWords">Say something nice to someone:</label>
            <textarea id="niceWords" name="niceWords" required></textarea>
        </div>

        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
</body>

</html>
