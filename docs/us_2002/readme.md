# US 2002

## 1. Context

*This task is being taken for the first time in Sprint B.*

## 2. Requirements

**US 2002** As Operator, I want to register an application of a candidate for a job opening and
import all files received.

**Acceptance Criteria:**

Q15 Ricardo – É o Operador que regista uma candidatura ou é o sistema que o faz automaticamente? E como integra o “plugin” de verificação da candidatura neste processo?

A15 Na US 2002 o Operator regista a candidatura. Para isso, é o Operator que inicia o processo mas o sistema deve importar os dados resultantes do Application File Bot de forma “automática” (Ver References da US 2002). O plugin referido entra neste processo através da US 2003, em que o Operador gera um ficheiro template com os dados a introduzir para validar uma candidatura. Na US 2004, o Operador, após preencher os dados específicos da candidatura (com base no ficheiro template anterior) submete no sistema esse ficheiro que vai ser usado para o sistema avaliar/verificar a candidatura. Se os critérios não forem atingidos a candidatura é recusada.

Q65 Micael – US2002 - UI and UX. I'd like to know what is the expected flow of executing US2002 (application registration and files import, by the operator). Can you reproduce step by step which actions should the operator execute? Example: 1. The system asks the operator for the candidate's email. 2. The operator enters the candidate's email. 3. The system asks for the job reference. 4. The operator enters the job reference. 5. The system creates the job application, if there is data for it in the shared folder.

A65. There are no specific requirements for the UI/UX but I think it will be more user friendly if the Operator could start the process by selecting the shared folder for the application to be imported.

Q133 Sousa – US2002- Número da candidatura- na Q24 é referido um número que identifica uma candidatura a uma job reference. Esse número é diferente em todas as candidaturas, independentemente da job reference? Poderá servir como id da candidatura?

A133. Para além da Q 24 veja por favor os exemplos de ficheiros disponibilizados pelo applications email bot. Sim, podemos considerar que esse número é único, nunca se repetindo.

Q136 Padilla – US200a, US1006 - I have understood that the registration of the candidate will always be done by the operator. I also have read this line in the documentation "The Operator of the Backoffice will import the files produced by the Applications File Bot and register the applications, creating candidates that dot not exist in the system" So I guess the mechanism that the Operator follows is display all the data of a candidate (US 1006), and if the system shows "this cadidate doesn't exit", the operator click in registering candidate (US 2000A) and then he/she registers the aplication, isn't it? Apart, could the Operator upload the CV of the candidate in the registering operation? or should it be done by the candidate in his/her console?

A136. Please see Q74 and all the others that refer to US2002. US2002 regards the import of the files that result from the Application File Bot. This import results in the creation of the respective applications in the system and possible creation of candidate user if it does not exist already. This is to be done automatically, without intervention of the operator. If, for some reason, the process encounters any problem (e.g., missing candidate date) it should interrupt the import a log/inform the operator. There is no US for the candidate to upload his/her CV. This is only done by email. Also, there is no US (apart from US2002) to import data from candidates.

Q140 Pinto – US2002 – O que se entende por "and import all files received"? Devemos persistir todos os ficheiros para cada Candidate na base de dados ou apenas guardar o diretório de cada Application?

A140 Aqui o termo importar deve ser visto mais como “consolidar” ou “registar” todos os ficheiros devidamente “incorporados” no sistema relativamente a uma candidatura. Normalmente isso poderia passar por importar esses ficheiros para a base de dados. No entanto, no contexto actual do projeto, pode passar apenas por registar alguma forma de acesso a esses ficheiros (por exemplo, guardando o caminho/path para os ficheiros que estão no “folder” partilhado ou outra forma similar)

Q74 Tiago – US2000a – Relativamente ao registo dos candidatos, os dados devem ser inseridos manualmente ou importados do ficheiro com os dados do candidato?

A74. Faz sentido que sejam importados do ficheiro, no âmbito da US2002. Eventualmente dar a possibilidade do utilizador fazer alterações, caso seja necessário. A US2000a refere-se a uma funcionalidade do Operador, manualmente, registar candidatos. (Nota: resposta actualizada em 2024/04/18, a negrito)

Q83 Leite – US2002 – Na descrição da US o PO refere uma importação de ficheiros e depois na referência à mesma a importação dos dados do ficheiro. Poderia esclarecer a que se refere a importação? São importações distintas? Têm destinos diferentes?

A83. Nessa US refiro-me à importação dos ficheiros gerados pelo Application File Bot. Quando me refiro aos dados, serão os dados do ficheiro de texto “A text file with the data of the application and candidate”, secção 2.2.3, um dos ficheiros gerados.

Q84 Leite – US2002 – Após a informação dos ficheiros que estiverem na shared folder forem utilizados pelo Operator para registar uma candidatura, devem estes permanecer na pasta ou serem eliminados? Caso não sejam apagados como determinamos quais é que ainda não foram "utilizados"?

A84. Admitindo que já foram importados para o sistema, não tenho requisitos adicionais quanto aos ficheiros. A segunda pergunta é um problema que deve ser resolvido pela solução proposta. Eu não tenho nada a dizer sobre esse aspeto.

## 3. Analysis

![SSD](analysis/us2002-SSD.svg)

## 4. Design

### 4.1. Sequence Diagram

![SD](design/us2002-SD.svg)
