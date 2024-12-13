# US 1001

## 1. Context

*This task is being taken for the first time in Sprint B.*

## 2. Requirements

**US 1001** As Customer Manager I want to register a customer and that the system automatically creates a user for that
customer

**Client Acceptance Criteria:**

* Q11: No enunciado não está explicita a informação a recolher para os Customers? Qual a informação necessária? E quando
  aos funcionários da empresa?

* A11: De facto isso não está explicito. No entanto, são referidos no nome da empresa e o seu endereço no âmbito de um
  job opening. Quanto aos utilizadores (representante da empresa que acede à Customer App) eu diria que serão dados
  similares ao do Candidate. Quando aos funcionários da empresa, eu diria que é importante garantir que é usado o email
  para identificar qualquer utilizador do sistema. Penso que será importante para cada utilizador termos o nome completo
  assim como um short user name (que deverá ser único). Actualização em 2024-03-21: O Product Owner reconsiderou e
  decidiu que o short user name é dispensável uma vez que para autenticação dos utilizadores se deve usar apenas o email
  e a password.


* Q13: Um customer manager pode gerir vários clientes?

* A13: Sim.


* Q22: Relativamente ao Job Opening (secção 2.2.2), o job reference refere que deve ser gerado pelo sistema a partir de
  um customer code. O que é este customer code e se existe alguma regra para a sua criação?

* A22: Eu dira que qualquer customer terá de ter um código identificativo (único) que poderá ser uma espécie de
  abreviatura do seu nome. Com um número limitado de caracteres. Por exemplo, para o cliente Instituto Superior de
  Engenharia do Porto, o customer code poderia ser ISEP e não poderia haver mais nenhum customer com este customer code.
  Um limite razoável seria talvez 8 a 10 carateres. Podemos definir 10. Este código é introduzido manualmente na criação
  do customer no sistema.

* Q135: US1001 - Customer Code - Relativamente ao formato do customer code, em todos os exemplos fornecidos, este
  é uma sigla/acrónimo com letras maiúsculas (ex: "ISEP", "IBM"). Só pode ter este formato ou pode conter números e
  letras minúsculas?

* A135: Ver Q22. Em Q22 sugere-se 10 caracteres no máximo. Penso que seria de manter apenas letras maiúsculas podendo
  ainda ter dígitos (0-9), mas começando sempre por letra.

**Dependencies/References:**

- In the project description it was mentioned as a reference that this user story can be achieved by using a bootstrap
  process.

## 3. Analysis

![SSD](analysis/us1001-RegisterCustomer-SSD.svg)

## 4. Design

In order to implement this US, a UI was implemented for the customer manager to introduce the data of a customer.
This data will then be passed to a controller in which the user for the customer is created and then an event is
published.
The event will be handled by a watchdog that will call a controller that after verifying that the user for the customer
exists, it will create and
save a customer in the system.
In case an error occurs an event will be published and a watchdog will call a controller that will delete the previous
user for the customer that was not created.

### 4.1. Sequence Diagram

![SD](design/us1001-RegisterCustomer-SD.svg)

### 4.3. Tests

**Refers to Client Acceptance Criteria:** A57

```
   @Test
    public void ensureCostumerEqualsPassesForTheSameCustomerCode() throws Exception {

        final Customer aCustomer = new CustomerBuilder().withCustomerCode("IGUAL").withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final Customer anotherCustomer = new CustomerBuilder().withCustomerCode("IGUAL").withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertTrue(expected);
    }


    @Test
    public void ensureCustomerEqualsFailsForDifferentCustomerCode() throws Exception {
        final Customer aCustomer = new CustomerBuilder().withCustomerCode(aCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final Customer anotherCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertFalse(expected);

    }

    @Test
    public void ensureCustomerUserEqualsFailsForDifferenteObjectTypes() throws Exception {

        final Customer aCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        @SuppressWarnings("unlikely-arg-type") final boolean expected = aCustomer.equals(getNewCustomerUser());

        assertFalse(expected);
    }

    @Test
    public void ensureCustomerUserIsTheSameAsItsInstance() throws Exception {
        final Customer aCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.sameAs(aCustomer);

        assertTrue(expected);
    }


    @Test
    public void ensureTwoCustomerUserWithDifferentCustomerCodesAreNotTheSame() throws Exception {

        final Customer aCustomer = new CustomerBuilder().withCustomerCode(aCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final Customer anotherCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.sameAs(anotherCustomer);

        assertFalse(expected);
    }
    
    
````

**Refers to Client Acceptance Criteria:** A22 135
**Refers to Client Acceptance Criteria:** A135

```
        @Test
    public void ensureCostumerCodeNotNull() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode(null);
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }

    @Test
    public void ensureCostumerCodeNotEmpty() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode("   ");
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }

    @Test
    public void ensureCostumerCodeDoesNotBeginWithNuber() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode("1COSTUM");
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }

    @Test
    public void ensureCostumerCodeDoesNotHaveMoreThan10Characters() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode("PLUS10CHARACTERS");
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }


    @Test
    public void ensureCostumerCodeLowerCaseGoesToUpper() throws Exception {


        final CustomerCode aCustomerCode = new CustomerCode("custCode1");

        final CustomerCode anotherCustomerCode = new CustomerCode("custCode1");

        final boolean expected = aCustomerCode.equals(anotherCustomerCode);

        assertTrue(expected);
    }
````