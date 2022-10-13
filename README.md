# Automatos-T1

<p>PUCRS/Escola Politécnica 2022/II <br>
Linguagens, Autômatos e Computação (Turma 030) <br>
Trabalho T1 <br>
Integrantes: Gabriel Spiandorello, Léo Falcão e Lucas Ehara</p>

# Gerando Automatos

   <h2>  <b> Relatório do trabalho prático 1 </b> </h2>   

   <h2>Entrada de dados:</h2>
      <p> 
         Com base nas regras passadas, o usuário precisa informar quais vão ser os terminais e não terminais (limitado a no máximo 2 caracteres), o símbolo que engloba o conjunto de produções foi pré-definido como <b>P</b> e o símbolo de início das produções foi pré-definido como <b>S</b>.
      </p>

   <h2>Saída:</h2>
      <p>Como pedido no enunciado do trabalho, o programa retorna o formalismo da gramática, testa se é válida ou não, retorna o tipo dela (Gramática regular ou gramática livre de contexto) e gera sentenças com base nas informações passadas na entrada de dados. </p> 

   <h3>Exemplo de Entrada:</h3>	
      <p>
      Não terminal: <b> A </b> <br>
      Terminal: <b> b </b> <br>
      Gramática <b> não </b> aceita vazio<br>
      </p>

   <h3>Exemplo de Saída:</h3>	
      <p>
      S -> bA | b <br>
      A -> bS  <br>
      </p>  
   
   <h3>Exemplo de sentenças possíves:</h3>
      <p>
         S -> bA -> bbS -> bbb <br>
         S -> b      <br>
         <b>Tipo Gramática: Livre de contexto </b> <br>
      </p>
