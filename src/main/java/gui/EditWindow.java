package gui;

import carsDB.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import carsDB.CarDB;
import companiesDB.Company;
import companiesDB.CompanyDB;
import employeesDB.Employee;
import employeesDB.EmployeeDataBase;

public class EditWindow extends JFrame {

    static CarDB carDB = new CarDB();
    static CompanyDB companyDB = new CompanyDB();
    static EmployeeDataBase employeeDataBase = new EmployeeDataBase();
    static List<Car> cars = carDB.getCarListFromDB();
    static List<Company> companies = companyDB.getCompanyListFromDB();
    static List<Employee> employeeList = employeeDataBase.getEmployeeListFromDB();
    static JTextArea name;
    static JTextArea surname;
    static JTextArea age;
    static JComboBox<String> carList;
    static JComboBox<String> companyList;

    public EditWindow(Employee em) throws HeadlessException {

        setSize(400, 500);
        setTitle("Edit employee data");
        JPanel mainPanel = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
         name = new JTextArea(em.getName());
        JLabel surnameLabel = new JLabel("Surname: ");
         surname = new JTextArea(em.getSurname());
        JLabel ageLabel = new JLabel("Age: ");
         age = new JTextArea(String.valueOf(em.getAge()));
        JLabel carLabel = new JLabel("Car: ");
        List<String> carNames = cars.stream().map(car -> car.getBrand() + " " + car.getModel()).collect(Collectors.toList());
         carList = new JComboBox(carNames.toArray());
        JLabel companyLabel = new JLabel("Company: ");
        List companyNames = companies.stream().map(company -> company.getName()).collect(Collectors.toList());
         companyList = new JComboBox(companyNames.toArray());
        JButton submit = new JButton("Submit");
        JButton cancel = new JButton("Cancel");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              editEmployee(em);
            }
        });

        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(name);
        JPanel surnamePanel = new JPanel();
        surnamePanel.add(surnameLabel);
        surnamePanel.add(surname);
        JPanel agePanel = new JPanel();
        agePanel.add(ageLabel);
        agePanel.add(age);
        JPanel carPanel = new JPanel();
        carPanel.add(carLabel);
        carPanel.add(carList);
        JPanel companyPanel = new JPanel();
        companyPanel.add(companyLabel);
        companyPanel.add(companyList);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submit);
        buttonPanel.add(cancel);
        mainPanel.add(namePanel);
        mainPanel.add(surnamePanel);
        mainPanel.add(agePanel);
        mainPanel.add(carPanel);
        mainPanel.add(companyPanel);
        mainPanel.add(buttonPanel);
        getContentPane().add(mainPanel);


    }
    public static Employee editEmployee (Employee em){
        em.setName(name.getText());
        em.setSurname(surname.getText());
        em.setAge(Integer.parseInt(age.getText()));
        String carName = (String) carList.getSelectedItem();
        String carModel = carName.split(" ")[1];
        for (Car c : cars){
            if (c.getModel().equalsIgnoreCase(carModel)){
                em.setCar(c);
            }
        }
        String companyName = (String) companyList.getSelectedItem();
        for (Company co : companies){
            if (co.getName().equalsIgnoreCase(companyName)){
                em.setCompany(co);
            }
        }
        employeeList.get(em.getId() -1 ).setNewValue(em);


        EmployeeView.employeeDataBase.saveEmployeeToDB(em);
        EmployeeView.employeeTableModel.setRowCount(0);
        EmployeeView.setCurrentView();

        return em;
    }
}
