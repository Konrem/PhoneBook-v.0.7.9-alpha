package ru.javastudy.beans;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@ManagedBean(name = "dialogBean")
@SessionScoped
public class DialogBean {

    private int Id;
    private String FirstName;
    private String SecondName;
    private String Phone;
    public DialogBean() {
    }

    public DialogBean(int Id, String FirstName, String SecondName, String Phone) {
        this.Id=Id;
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.Phone = Phone;
    }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id=Id;
    }

    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }
    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void showMessage() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        FacesMessage message = new FacesMessage("Заголовок", "Частичное обновление страницы");
        message.setSeverity(FacesMessage.SEVERITY_INFO); //как выглядит окошко с сообщением

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"First Name", FirstName));

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Second Name", SecondName));

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Phone", Phone));

        BookBean.insertSql(FirstName,SecondName,Phone);

    }


    public void preDelete(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        BookBean.deleteSql(id);


    }
    public void preEdit(int Id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<DialogBean> books1 = new ArrayList<DialogBean>();
        books1=BookBean.getBooks1(Id);
        this.Id=books1.get(0).Id;
        this.FirstName=books1.get(0).FirstName;
        this.SecondName=books1.get(0).SecondName;
        this.Phone=books1.get(0).Phone;

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg2').show();");
    }
     public void edit() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

         BookBean.updateSql(Id,FirstName,SecondName,Phone);


     }

}