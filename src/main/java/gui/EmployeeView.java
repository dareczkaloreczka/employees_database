package gui;

import carsDB.Car;
import carsDB.CarDB;
import companiesDB.Company;
import companiesDB.CompanyDB;
import employeesDB.Employee;
import employeesDB.EmployeeDataBase;
import employeesDB.EmployeeMapper;
import exceptions.NegativeNumberException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class EmployeeView extends JFrame {

    public EmployeeView() throws HeadlessException {

        inicjalizacja();
    }

    static List<Employee> employeeList;
    static List<Car> carList;
    static List<Company> companyList;
    static JTable employeeJtable;
    static MyTableModel employeeTableModel;
    JTextField insertName;
    JTextField insertSurname;
    JTextField insertAge;
    JTextField insertCompanyId;
    JTextField insertCarId;
    static EmployeeDataBase employeeDataBase = new EmployeeDataBase();
    static CarDB carDB = new CarDB();
    static CompanyDB companyDB = new CompanyDB();
    static EmployeeMapper employeeMapper = new EmployeeMapper();

    private void inicjalizacja() {


        setTitle("Employees Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 500);

        employeeTableModel = new MyTableModel();
        employeeTableModel.addColumn("ID");
        employeeTableModel.addColumn("First Name");
        employeeTableModel.addColumn("Last Name");


        employeeJtable = new JTable(employeeTableModel);
        insertName = new JTextField("Insert Name:");
        insertName.requestFocus();
        insertSurname = new JTextField("Last name:");
        insertAge = new JTextField("Age:");
        insertCompanyId = new JTextField("Company ID:");
        insertCarId = new JTextField("Car ID:");
        JButton addUserButton = new JButton("Add employee");

        JTextField insertBrand = new JTextField("Brand:");
        JTextField insertModel = new JTextField("Model:");
        JTextField insertYear = new JTextField("Year:");
        JTextField insertRegBoard = new JTextField("Reg Number:");
        JButton addCarButton = new JButton("Add car");

        JTextField insertCompanyName = new JTextField("Company name:");
        JTextField insertaddress = new JTextField("Address:");
        JTextField insertNoE = new JTextField("Number of employees:");
        JButton addCompanyButton = new JButton("Add Company");

        JPanel addEmployeePanel = new JPanel();
        JLabel addEmployee = new JLabel("Add Employee");
        JPanel employeePanel = new JPanel();
        addEmployeePanel.setLayout(new GridLayout(3, 2));
        addEmployeePanel.add(insertName);
        addEmployeePanel.add(insertSurname);
        addEmployeePanel.add(insertAge);
        addEmployeePanel.add(insertCompanyId);
        addEmployeePanel.add(insertCarId);
        addEmployeePanel.add(addUserButton);

        JPanel addCarPanel = new JPanel();
        JLabel addCar = new JLabel("Add Car");
        JPanel carPanel = new JPanel();
        addCarPanel.setLayout(new GridLayout(3, 2));
        addCarPanel.add(insertBrand);
        addCarPanel.add(insertModel);
        addCarPanel.add(insertYear);
        addCarPanel.add(insertRegBoard);
        addCarPanel.add(addCarButton);

        JPanel addCompanyPanel = new JPanel();
        JLabel addCompany = new JLabel("Add Company");
        JPanel companyPanel = new JPanel();
        addCompanyPanel.setLayout(new GridLayout(3, 2));
        addCompanyPanel.add(insertCompanyName);
        addCompanyPanel.add(insertaddress);
        addCompanyPanel.add(insertNoE);
        addCompanyPanel.add(addCompanyButton);

        employeePanel.setLayout(new GridLayout(0, 1));
        employeePanel.add(addEmployee);
        employeePanel.add(addEmployeePanel);

        carPanel.setLayout(new GridLayout(0, 1));
        carPanel.add(addCar);
        carPanel.add(addCarPanel);

        companyPanel.setLayout(new GridLayout(0, 1));
        companyPanel.add(addCompany);
        companyPanel.add(addCompanyPanel);

        JPanel addingPanel = new JPanel();
        addingPanel.setLayout(new GridLayout(3, 1));
        addingPanel.add(employeePanel);
        addingPanel.add(carPanel);
        addingPanel.add(companyPanel);

        JPanel infoPanel = new JPanel();
        JLabel employeeDetails = new JLabel("Employee's details");
        JLabel nameAndSurname = new JLabel("Name & surname:");
        JTextArea showNameAndSurname = new JTextArea("");
        showNameAndSurname.setEditable(false);
        JLabel age = new JLabel("Age:");
        JTextArea showAge = new JTextArea("");
        showAge.setEditable(false);
        JLabel car = new JLabel("Car:");
        JTextArea showCar = new JTextArea("");
        showCar.setEditable(false);
        JLabel company = new JLabel("Company:");
        JTextArea showCompany = new JTextArea("");
        showCompany.setEditable(false);
        JPanel editPanel = new JPanel();
        JButton editButton = new JButton("Edit");
        JButton removeButton = new JButton("Remove");
        editPanel.add(editButton);
        editPanel.add(removeButton);
        infoPanel.setLayout(new GridLayout(0, 1));
        infoPanel.add(employeeDetails);
        infoPanel.add(nameAndSurname);
        infoPanel.add(showNameAndSurname);
        infoPanel.add(age);
        infoPanel.add(showAge);
        infoPanel.add(car);
        infoPanel.add(showCar);
        infoPanel.add(company);
        infoPanel.add(showCompany);
        infoPanel.add(editPanel);

        JScrollPane scrollPanePanel = new JScrollPane(employeeJtable);
        scrollPanePanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanePanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().add(BorderLayout.WEST, scrollPanePanel);
        getContentPane().add(BorderLayout.EAST, addingPanel);
        getContentPane().add(BorderLayout.CENTER, infoPanel);


        setCurrentView();

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (employeeJtable.getSelectedRow() > -1) {
                    int row = employeeJtable.getSelectedRow();
                    int index = Integer.parseInt((String) employeeJtable.getModel().getValueAt(row, 0));
                    Employee em = employeeList.get(index - 1);
                    EditWindow editWindow = new EditWindow(em);
                    editWindow.setVisible(true);


                }
            }
            });


       addUserButton.addActionListener(new

            ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    Employee newEmployee = null;
                    try {
                        newEmployee = new Employee(employeeList.size() + 1, insertName.getText(), insertSurname.getText(),
                                Integer.parseInt(insertAge.getText()), Integer.parseInt(insertCompanyId.getText()), Integer.parseInt(insertCarId.getText()));
                    } catch (NegativeNumberException e1) {
                        System.out.println(e1.getMessage());
                    }
                    employeeList.add(newEmployee);
                    employeeDataBase.saveEmployeeToDB(newEmployee);
                    insertName.setText("Insert first name:");
                    insertAge.requestFocus();
                    insertSurname.setText("Last Name:");
                    insertAge.setText("Age:");
                    insertCompanyId.setText("Company ID:");
                    insertCarId.setText("Car ID:");

                    employeeTableModel.setRowCount(0);
                    setCurrentView();
                }
            });

       addCarButton.addActionListener(new

            ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    Car newCar = null;
                    try {
                        newCar = new Car(carList.size() + 1, insertBrand.getText(), insertModel.getText(),
                                insertYear.getText(), insertRegBoard.getText());
                    } catch (NegativeNumberException e1) {
                        System.out.println(e1.getMessage());
                    }
                    carList.add(newCar);
                    carDB.saveCarToDB(newCar);
                    insertBrand.setText("Brand:");
                    insertModel.setText("Model:");
                    insertYear.setText("Year:");
                    insertRegBoard.setText("Reg number:");

                    employeeTableModel.setRowCount(0);
                    setCurrentView();

                }
            });

       addCompanyButton.addActionListener(new

            ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    Company newCompany = null;
                    try {
                        newCompany = new Company(companyList.size() + 1, insertCompanyName.getText(),
                                insertaddress.getText(), Integer.parseInt(insertNoE.getText()));
                    } catch (NegativeNumberException e1) {
                        System.out.println(e1.getMessage());
                    }
                    companyList.add(newCompany);
                    companyDB.saveCompanyToDB(newCompany);
                    insertCompanyName.setText("Company name:");
                    insertaddress.setText("Address:");
                    insertNoE.setText("Number of employees:");
                }
            });

       employeeJtable.getSelectionModel().

            addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged (ListSelectionEvent e){
                    if (employeeJtable.getSelectedRow() > -1) {
                        int row = employeeJtable.getSelectedRow();
                        int index = Integer.parseInt((String) employeeJtable.getModel().getValueAt(row, 0));
                        Employee em = employeeList.get(index - 1);
                        showNameAndSurname.setText(em.getName() + " " + em.getSurname());
                        showAge.setText(String.valueOf(em.getAge()));
                        showCar.setText(em.getCar().getProductionYear() + " " + em.getCar().getBrand()
                                + " " + em.getCar().getModel() + "\n" + em.getCar().getRegBoard());
                        showCompany.setText(em.getCompany().getName() + "\n" + em.getCompany().getAddress() + "\n"
                                + "number of employees: " + String.valueOf(em.getCompany().getNumberOfEmployees()));
                    }
                }
            });

        }

    public static void setCurrentView() {

        employeeList = employeeDataBase.getEmployeeListFromDB();
        carList = carDB.getCarListFromDB();
        companyList = companyDB.getCompanyListFromDB();
        for (Employee employee : employeeList) {
            String[] userData = {String.valueOf(employee.getId()), employee.getName(), employee.getSurname()};
            employeeTableModel.addRow(userData);

        }
    }
}
