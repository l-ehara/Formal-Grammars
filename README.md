# Automata-T1

<p>PUCRS/School of Engineering 2022/II <br>
Languages, Automata and Computing (Class 030) <br>
Assignment T1 <br>
Members: Gabriel Spiandorello, Léo Falcão and Lucas Ehara</p>

   <h1>  <b> Report of Practical Assignment 1 </b> </h1>   

   <h2>Data Input:</h2>
      <p> 
         Based on the given rules, the user needs to specify what will be the terminals and non-terminals (limited to a maximum of 2 characters), the symbol that encompasses the set of productions was predefined as <b>P</b> and the start symbol of the productions was predefined as <b>S</b>.
      </p>

   <h2>Output:</h2>
      <p>As requested in the assignment statement, the program returns the formalism of the grammar, tests whether it is valid or not, returns its type (Regular Grammar or Context-Free Grammar) and generates sentences based on the information provided in the data input. </p> 

   <h3>Example of Input:</h3>	
      <p>
      Non-terminal: <b> A </b> <br>
      Terminal: <b> b </b> <br>
      Grammar <b> does not </b> accept empty<br>
      </p>

   <h3>Example of Output:</h3>	
      <p>
      S -> bA | b <br>
      A -> bS  <br>
      </p>  
   
   <h3>Examples of possible sentences:</h3>
      <p>
         S -> bA -> bbS -> bbb <br>
         S -> b      <br>
         <b>Type of Grammar: Context-Free </b> <br>
      </p>
