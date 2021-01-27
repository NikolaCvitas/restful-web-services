package hr.cvitas.rest.webservices.restfulwebservices.controller;

public class TestBean {

    private String message;

    public TestBean(String message){
        this.message = message;

    }

    public void setMessage(String message){
        this.message  = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
