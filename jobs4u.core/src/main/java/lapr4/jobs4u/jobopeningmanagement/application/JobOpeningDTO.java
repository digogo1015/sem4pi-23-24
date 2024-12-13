package lapr4.jobs4u.jobopeningmanagement.application;

import java.io.Serializable;

public class JobOpeningDTO implements Serializable {

    private final String title;
    private final String reference;
    private final String date;
    private final String vacancies;

    public JobOpeningDTO(String title, String reference, String date, String vacancies) {
        this.title = title;
        this.reference = reference;
        this.date = date;
        this.vacancies = vacancies;
    }

    public String title() {
        return title;
    }

    public String reference() {
        return reference;
    }

    public String date() {
        return date;
    }

    public String vacancies() {
        return vacancies;
    }


}
