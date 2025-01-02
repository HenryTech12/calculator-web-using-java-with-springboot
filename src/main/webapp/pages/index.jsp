<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>HTML</title>
  
  <!-- HTML -->
  

  <!-- Custom Styles -->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>

<body>
  <!-- Project -->
  <form action="calculate" method="post">
  <div class="screen-container">
     <span class="screen">${value}</span>
   </div>
  <main class="container">
    <button value="C" name="operator" class="op opH">C</button>
    <button value="%" name="operator" class="op">%</button>
    <button value="del" name="del" class="op">
      <span class="material-symbols-outlined" style="font-size: 2rem;">
      backspace
      </span>
    </button>
    <button value="/" name="operator" class="op">/</button>
    
    <button value="7" name="number">7</button>
    <button value="8" name="number">8</button>
    <button value="9" name="number">9</button>
    <button value="*" name="operator" class="op">X</button>
    
    <button value="4" name="number">4</button>
    <button value="5" name="number">5</button>
    <button value="6" name="number">6</button>
    <button value="-" name="operator" class="op">-</button>
    
    
    <button value="1" name="number">1</button>
    <button value="2" name="number">2</button>
    <button value="3" name="number">3</button>
    <button value="+" name="operator" class="op">+</button>
    
    
    <button value="00" name="number">00</button>
    <button value="0" name="number">0</button>
    <button value="d" name="dot">.</button>
    <button value="e" name="operator" class="opE">=</button>
  </main>
       <br>
  </form>
</body>
</html>