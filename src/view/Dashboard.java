/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import com.itextpdf.pdfa.PdfADocument;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import controller.ManageSalary;
import controller.ManageEmployeeType;
import controller.ManageEmployee;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.EmployeeType;
import model.Database;
import model.Employee;
import net.proteanit.sql.DbUtils;
import model.Salary;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author malith
 */
public final class Dashboard extends javax.swing.JFrame {

    /** Creates new form Dashboard */
    public Dashboard() {
       
        initComponents();
        Welcome();
        jPDashboard.setVisible(true);
        jPEmployeeType.setVisible(false);
        jPEmployee.setVisible(false);
        jPSalary.setVisible(false);
        jPReport.setVisible(false);
  
    }
    
    
    
public class salary {
        
        
    public String SalID;
    public String EmpID;
    public String EmpName;
    public String EmpType;
    public String Salary;
    public String Allowance;

    public void getData(){
        
        this.Salary=txtSalSalary.getText();
        this.Allowance=txtSalAllowance.getText();  
    }
     public void Calculate(){
         double TotalAmount=0;
         double salary=Double.parseDouble(Salary); 
         double allowance=Double.parseDouble(Allowance); 
         
         TotalAmount=(salary+allowance); 
         String TA=Double.toString(TotalAmount);
         
            this.SalID=txtSalId.getText();
            this.EmpID=cmbSalEmpID.getSelectedItem().toString();
            this.EmpName=txtSalEmpName.getText();
            this.EmpType=txtSalEmpType.getText();
            this.Salary=TA;
            this.Allowance=txtSalAllowance.getText();
    }
     
    public void setData(){
         Salary salary = new Salary(SalID,EmpID,EmpName,EmpType,Salary,Allowance);
         ManageSalary salary1=new ManageSalary(salary);
         salary1.saveSalary();
    }
    
}

class CaretakerSal extends salary{
    @Override
    public void getData(){
        
        this.Salary=txtSalSalary.getText();
        this.Allowance=txtSalAllowance.getText();  
    }
    @Override
     public void Calculate(){
         double TotalAmount=0;
         double salary=Double.parseDouble(Salary); 
         double allowance=Double.parseDouble(Allowance); 
         
         TotalAmount=((salary+allowance)*0.3)+(salary+allowance);  
         String TA=Double.toString(TotalAmount);
         
            this.SalID=txtSalId.getText();
            this.EmpID=cmbSalEmpID.getSelectedItem().toString();
            this.EmpName=txtSalEmpName.getText();
            this.EmpType=txtSalEmpType.getText();
            this.Salary=TA;
            this.Allowance=txtSalAllowance.getText();
    }
     
    @Override
    public void setData(){
         Salary salary = new Salary(SalID,EmpID,EmpName,EmpType,Salary,Allowance);
         ManageSalary salary1=new ManageSalary(salary);
         salary1.saveSalary();
    }
    
}

class EmployeeSal extends salary{
    @Override
    public void getData(){
        
        this.Salary=txtSalSalary.getText();
        this.Allowance=txtSalAllowance.getText();  
    }
    @Override
     public void Calculate(){
         double TotalAmount=0;
         double salary=Double.parseDouble(Salary); 
         double allowance=Double.parseDouble(Allowance); 
         
         TotalAmount=((salary+allowance)*0.4)+(salary+allowance);  
         String TA=Double.toString(TotalAmount);
         
            this.SalID=txtSalId.getText();
            this.EmpID=cmbSalEmpID.getSelectedItem().toString();
            this.EmpName=txtSalEmpName.getText();
            this.EmpType=txtSalEmpType.getText();
            this.Salary=TA;
            this.Allowance=txtSalAllowance.getText();
    }
     
    @Override
    public void setData(){
         Salary salary = new Salary(SalID,EmpID,EmpName,EmpType,Salary,Allowance);
         ManageSalary salary1=new ManageSalary(salary);
         salary1.saveSalary();
    }
    
}



class SecuritySal extends salary{
    @Override
    public void getData(){
        
        this.Salary=txtSalSalary.getText();
        this.Allowance=txtSalAllowance.getText();  
    }
    @Override
     public void Calculate(){
         double TotalAmount=0;
         double salary=Double.parseDouble(Salary); 
         double allowance=Double.parseDouble(Allowance); 
         
         TotalAmount=((salary+allowance)*0.1)+(salary+allowance);  
         String TA=Double.toString(TotalAmount);
         
            this.SalID=txtSalId.getText();
            this.EmpID=cmbSalEmpID.getSelectedItem().toString();
            this.EmpName=txtSalEmpName.getText();
            this.EmpType=txtSalEmpType.getText();
            this.Salary=TA;
            this.Allowance=txtSalAllowance.getText();
    }
     
    @Override
    public void setData(){
         Salary salary = new Salary(SalID,EmpID,EmpName,EmpType,Salary,Allowance);
         ManageSalary salary1=new ManageSalary(salary);
         salary1.saveSalary();
    }
    
}

class ManagerSal extends salary{
    
    public void getData(){
        
        this.Salary=txtSalSalary.getText();
        this.Allowance=txtSalAllowance.getText();  
        
    }
    @Override
     public void Calculate(){
         double TotalAmount=0;
         double salary=Double.parseDouble(Salary); 
         double allowance=Double.parseDouble(Allowance); 
         
         TotalAmount=((salary+allowance)*0.5)+(salary+allowance); 
         String TA=Double.toString(TotalAmount);
         
            this.SalID=txtSalId.getText();
            this.EmpID=cmbSalEmpID.getSelectedItem().toString();
            this.EmpName=txtSalEmpName.getText();
            this.EmpType=txtSalEmpType.getText();
            this.Salary=TA;
            this.Allowance=txtSalAllowance.getText();
     }
     
    @Override
    public void setData(){
         Salary salary = new Salary(SalID,EmpID,EmpName,EmpType,Salary,Allowance);
         ManageSalary salary1=new ManageSalary(salary);
         salary1.saveSalary();
    }
    
}


    
    
    
    
    
    public void setEmpEmpTypeNameCombo(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM emptype");
            
          while (rs.next()) {
                String EmpTypeName = rs.getString("EmpTypeName");
                    
                    cmbEType.removeItem(EmpTypeName);
                    cmbEType.addItem(EmpTypeName);
                    
                if(cmbEType.getSelectedItem().toString().equals(EmpTypeName)){       
                }

                else{
                    cmbEType.removeItem(EmpTypeName);
                    cmbEType.addItem(EmpTypeName);
                }
                 
            }
        }catch(SQLException e){
           System.out.println("Error"+e.getMessage());     
        }
         catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }
    
    
    
    public void setSalEmpType(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            String SalEmpID=cmbSalEmpID.getSelectedItem().toString();
            ResultSet rs = stmt.executeQuery("SELECT EmpType FROM employee WHERE EmpID='"+SalEmpID+"'");
            
 
          while (rs.next()) {
                String SalEmpType = rs.getString("EmpType");
  
                    txtSalEmpType.setText(SalEmpType);  

          }
          
        }catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }   
    }
    
    public void setSalEmpSalary(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            String SalEmpID=cmbSalEmpID.getSelectedItem().toString();
            ResultSet rs = stmt.executeQuery("SELECT EmpSalary FROM employee WHERE EmpID='"+SalEmpID+"'");
            
 
          while (rs.next()) {
                String SalEmpSalary = rs.getString("EmpSalary");
  
                    txtSalSalary.setText(SalEmpSalary);  

          }
          
         }catch(SQLException e){
           System.out.println("Error"+e.getMessage());     
        }
         catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }  
    }
    
     public void setSalEmpTotalSalary(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            String SalSAlID=txtSalId.getText();
            ResultSet rs = stmt.executeQuery("SELECT SalTotal FROM empsalary WHERE SalID='"+SalSAlID+"'");
            
 
          while (rs.next()) {
                String SalEmpSalaryTotal = rs.getString("SalTotal");
  
                    txtSalTotalAmount.setText(SalEmpSalaryTotal);  

          }
          
        }catch(SQLException e){
           System.out.println("Error"+e.getMessage());     
        }
         catch (Exception e) {
           System.out.println("Error"+e.getMessage());
        }  
    }
 

    
        
    public void setSalEmpIDCombo(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT EmpID FROM employee");
            
            
          while (rs.next()) {
                String SalEmpID = rs.getString("EmpID");
               
                
                    cmbSalEmpID.removeItem(SalEmpID);
                    cmbSalEmpID.addItem(SalEmpID);
                    
                    
                if(cmbSalEmpID.getSelectedItem().toString().equals(SalEmpID)){
                        
                }

                else{

                    cmbSalEmpID.removeItem(SalEmpID);
                    cmbSalEmpID.addItem(SalEmpID);
  
                }
          }
          

        }catch(SQLException e){
         System.out.println("Error"+e.getMessage());    
        }
         catch (Exception e) {
         System.out.println("Error"+e.getMessage());
        }  
    }
    
    
    public void setSalEmpName(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            String SalEmpID=cmbSalEmpID.getSelectedItem().toString();
            ResultSet rs = stmt.executeQuery("SELECT EmpName FROM employee WHERE EmpID='"+SalEmpID+"'");
            
 
          while (rs.next()) {
                String SalEmpName = rs.getString("EmpName");
  
                    txtSalEmpName.setText(SalEmpName);  

          }
          
            
	}catch(SQLException e){
          System.out.println("Error"+e.getMessage());
        }
         catch (Exception e) {
          System.out.println("Error"+e.getMessage());
        }
    }
    
    public void setEmpSalary(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            String EmpTypeName=cmbEType.getSelectedItem().toString();
            ResultSet rs = stmt.executeQuery("SELECT EmpTypeSalary FROM emptype WHERE EmpTypeName='"+EmpTypeName+"'");
            
 
          while (rs.next()) {
                String SalEmpSalary = rs.getString("EmpTypeSalary");
  
                    txtESalary.setText(SalEmpSalary);  

          }
          
            
	}catch(SQLException e){
           System.out.println("Error"+e.getMessage());    
        }
         catch (Exception e) {
           System.out.println("Error"+e.getMessage());
        }
    }
      
    
    public void getEmpTypeID(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rsEmpTypeID = stmt.executeQuery("SELECT EmpTypeID FROM emptype ORDER BY EmpTypeID DESC LIMIT 1");
            
               
            while (rsEmpTypeID.next()) {
                
                String EmpTypeID = rsEmpTypeID.getString("EmpTypeID");
                StringBuilder sb3 = new StringBuilder(EmpTypeID);
                sb3.deleteCharAt(0);
                String resultString3 = sb3.toString();
                int EmpTypeIDNo= Integer.parseInt(resultString3);
                
                EmpTypeIDNo=EmpTypeIDNo+1;

                txtTypeID.setText("T"+String.valueOf(EmpTypeIDNo));
                 
            }
            
 
	}catch(SQLException e){
           System.out.println("Error"+e.getMessage());     
        }
         catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }
    public void getEmpID(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rsEmpID = stmt.executeQuery("SELECT EmpID FROM employee ORDER BY EmpID DESC LIMIT 1");
            

               while (rsEmpID.next()) {
                String EmpID = rsEmpID.getString("EmpID");
                StringBuilder sb2 = new StringBuilder(EmpID);
                sb2.deleteCharAt(0);
                String resultString2 = sb2.toString();
                int EmpIDNo= Integer.parseInt(resultString2);
                
                EmpIDNo=EmpIDNo+1;

                txtEID.setText("E"+String.valueOf(EmpIDNo));
               }
               
               
	}catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"DataBase Error!", JOptionPane.ERROR_MESSAGE);     
        }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void getSalID(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rsSalID = stmt.executeQuery("SELECT SalID FROM empSalary ORDER BY SalID DESC LIMIT 1");
            
           while (rsSalID.next()) {
                String SalID = rsSalID.getString("SalID");
                StringBuilder sb1 = new StringBuilder(SalID);
                sb1.deleteCharAt(0);
                String resultString1 = sb1.toString();
                int SalIDNo= Integer.parseInt(resultString1);
                
                SalIDNo=SalIDNo+1;

                txtSalId.setText("S"+String.valueOf(SalIDNo));
                 
            }

	}
        catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"DataBase Error!", JOptionPane.ERROR_MESSAGE);     
        }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   
    
    
    
    
    public void calculateTotalSalary(){
        try {
            
           Double Salary = Double.parseDouble( txtSalSalary.getText());
           Double Allowance = Double.parseDouble( txtSalAllowance.getText());
           
           Double Total=Salary+Allowance;
           txtSalTotal.setText(Total.toString());
           
    
	 }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    int i=0;
    public void CreatPaySheet(){
     
        try {

             TextAreaPaySheet.setText("\t==PAYSHEET=="+"\n\n  SALARYID\t "+txtSalId.getText()+"\n  EMPID\t"+cmbSalEmpID.getSelectedItem().toString()+"\n  EMPTYPE\t"+txtSalEmpType.getText()+"\n  EMPNAME\t"+txtSalEmpName.getText()+"\n  BASICSALARY\t"+txtSalSalary.getText()+"\n  ALLOWANCE\t"+txtSalAllowance.getText()+"\n  TOTAL\t"+txtSalTotal.getText()+"\n\n  MONTHLY TOTAL SALARY\t"+txtSalTotalAmount.getText()+"\n");
                   
	 }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
      
    }
    
    
     public void viewEmployee(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
  
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            jTableEmployee.setModel(DbUtils.resultSetToTableModel(rs));
               
          
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"DataBase Error!", JOptionPane.ERROR_MESSAGE);     
        }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void viewEmpType(){
        try {
            Connection con= Database.createConnection();
            Statement stmt = con.createStatement();
  
            ResultSet rs = stmt.executeQuery("SELECT * FROM emptype");
            jTableEmpType.setModel(DbUtils.resultSetToTableModel(rs));
           
          
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"DataBase Error!", JOptionPane.ERROR_MESSAGE);     
        }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
      public void EmpClear(){
        try {
            txtEID.setText(null);
            txtEname.setText(null);
            txtESalary.setText(null);
            cmbEType.setSelectedIndex(0);
            getEmpID();
           
          
          }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
      
      
      
       public void EmpTypeClear(){
        try {
            
            txtTypeID.setText(null);
            txtTypeName.setText(null);
            txtTypeSalary.setText(null);
            getEmpTypeID(); 
          
          }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
       
       
       
        public void BillClear(){
        try {
            txtSalId.setText(null);
            cmbSalEmpID.setSelectedIndex(0);
            txtSalSalary.setText(null);
            txtSalTotalAmount.setText(null);
            txtSalAllowance.setText(null);
            txtSalEmpType.setText(null);
            txtSalTotal.setText(null);
            txtSalEmpName.setText(null);
            TextAreaPaySheet.setText(null);
            getSalID();   
           
          
          }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
   public void Welcome(){
       lblWelcome.setText("HI! WELCOME");
    }


    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPmenuItem = new javax.swing.JPanel();
        jPmenuDashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPmenuAddEmployee = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPmenuSalary = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPmenuReport = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPmenuAddEmployeeType = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jPView = new javax.swing.JPanel();
        jPDashboard = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        iconCloseDashboard = new javax.swing.JLabel();
        iconmaxDashboard = new javax.swing.JLabel();
        iconMinDashboard = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        jPEmployee = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEID = new javax.swing.JTextField();
        txtEname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtESalary = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbEType = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnEmployeeAdd = new javax.swing.JButton();
        btnEmployeeUpdate = new javax.swing.JButton();
        btnEmployeeDelete = new javax.swing.JButton();
        btnEmployeeClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        btnEmployeeView = new javax.swing.JButton();
        iconmaxEmployee = new javax.swing.JLabel();
        iconMinEmployee = new javax.swing.JLabel();
        iconCloseEmployee = new javax.swing.JLabel();
        jPSalary = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSalId = new javax.swing.JTextField();
        txtSalSalary = new javax.swing.JTextField();
        txtSalAllowance = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnCalculateSalary = new javax.swing.JButton();
        btnSalaryClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaPaySheet = new javax.swing.JTextArea();
        btnPaySheet = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cmbSalEmpID = new javax.swing.JComboBox<>();
        txtSalEmpType = new javax.swing.JTextField();
        txtSalEmpName = new javax.swing.JTextField();
        txtSalTotalAmount = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtSalTotal = new javax.swing.JTextField();
        iconMinSalary = new javax.swing.JLabel();
        iconmaxSalary = new javax.swing.JLabel();
        iconCloseSalary = new javax.swing.JLabel();
        btnSaveSalPdf = new javax.swing.JButton();
        jPReport = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnSalaryReport = new javax.swing.JButton();
        iconCloseReport = new javax.swing.JLabel();
        iconmaxReport = new javax.swing.JLabel();
        iconMinReport = new javax.swing.JLabel();
        jPEmployeeType = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTypeID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTypeName = new javax.swing.JTextField();
        btnETypeAdd = new javax.swing.JButton();
        btnETypeUpdate = new javax.swing.JButton();
        btnETypeDelete = new javax.swing.JButton();
        btnETypeClear = new javax.swing.JButton();
        btnETypeView = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableEmpType = new javax.swing.JTable();
        txtTypeSalary = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        iconCloseType = new javax.swing.JLabel();
        iconmaxType = new javax.swing.JLabel();
        iconMinType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPmenuItem.setBackground(new java.awt.Color(0, 102, 255));
        jPmenuItem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPmenuItemMouseDragged(evt);
            }
        });
        jPmenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPmenuItemMousePressed(evt);
            }
        });

        jPmenuDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPmenuDashboardMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dashboard");

        javax.swing.GroupLayout jPmenuDashboardLayout = new javax.swing.GroupLayout(jPmenuDashboard);
        jPmenuDashboard.setLayout(jPmenuDashboardLayout);
        jPmenuDashboardLayout.setHorizontalGroup(
            jPmenuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPmenuDashboardLayout.setVerticalGroup(
            jPmenuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPmenuDashboardLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPmenuAddEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPmenuAddEmployeeMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employee");

        javax.swing.GroupLayout jPmenuAddEmployeeLayout = new javax.swing.GroupLayout(jPmenuAddEmployee);
        jPmenuAddEmployee.setLayout(jPmenuAddEmployeeLayout);
        jPmenuAddEmployeeLayout.setHorizontalGroup(
            jPmenuAddEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuAddEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPmenuAddEmployeeLayout.setVerticalGroup(
            jPmenuAddEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPmenuAddEmployeeLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPmenuSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPmenuSalaryMouseClicked(evt);
            }
        });
        jPmenuSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPmenuSalaryKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Salary");

        javax.swing.GroupLayout jPmenuSalaryLayout = new javax.swing.GroupLayout(jPmenuSalary);
        jPmenuSalary.setLayout(jPmenuSalaryLayout);
        jPmenuSalaryLayout.setHorizontalGroup(
            jPmenuSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPmenuSalaryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPmenuSalaryLayout.setVerticalGroup(
            jPmenuSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPmenuSalaryLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPmenuReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPmenuReportMouseClicked(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Report");

        javax.swing.GroupLayout jPmenuReportLayout = new javax.swing.GroupLayout(jPmenuReport);
        jPmenuReport.setLayout(jPmenuReportLayout);
        jPmenuReportLayout.setHorizontalGroup(
            jPmenuReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPmenuReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPmenuReportLayout.setVerticalGroup(
            jPmenuReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPmenuReportLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPmenuAddEmployeeType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPmenuAddEmployeeTypeMouseClicked(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Employee Type");

        javax.swing.GroupLayout jPmenuAddEmployeeTypeLayout = new javax.swing.GroupLayout(jPmenuAddEmployeeType);
        jPmenuAddEmployeeType.setLayout(jPmenuAddEmployeeTypeLayout);
        jPmenuAddEmployeeTypeLayout.setHorizontalGroup(
            jPmenuAddEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuAddEmployeeTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPmenuAddEmployeeTypeLayout.setVerticalGroup(
            jPmenuAddEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPmenuAddEmployeeTypeLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        lblLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setText("logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPmenuItemLayout = new javax.swing.GroupLayout(jPmenuItem);
        jPmenuItem.setLayout(jPmenuItemLayout);
        jPmenuItemLayout.setHorizontalGroup(
            jPmenuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPmenuDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPmenuAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPmenuSalary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPmenuReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPmenuAddEmployeeType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPmenuItemLayout.setVerticalGroup(
            jPmenuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuItemLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPmenuDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPmenuAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPmenuAddEmployeeType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPmenuSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPmenuReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblLogout)
                .addGap(32, 32, 32))
        );

        jPView.setBackground(new java.awt.Color(255, 255, 255));

        jPDashboard.setBackground(new java.awt.Color(153, 255, 255));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 255));
        jLabel14.setText("DASHBOARD");

        iconCloseDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        iconCloseDashboard.setToolTipText("Close");
        iconCloseDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        iconCloseDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCloseDashboardMouseClicked(evt);
            }
        });

        iconmaxDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maximize.png"))); // NOI18N
        iconmaxDashboard.setToolTipText("Maximize");
        iconmaxDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconmaxDashboardMouseClicked(evt);
            }
        });

        iconMinDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        iconMinDashboard.setToolTipText("Minimize");
        iconMinDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMinDashboardMouseClicked(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg.png"))); // NOI18N

        javax.swing.GroupLayout jPDashboardLayout = new javax.swing.GroupLayout(jPDashboard);
        jPDashboard.setLayout(jPDashboardLayout);
        jPDashboardLayout.setHorizontalGroup(
            jPDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDashboardLayout.createSequentialGroup()
                .addGap(0, 159, Short.MAX_VALUE)
                .addComponent(jLabel27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDashboardLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDashboardLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconMinDashboard))
                    .addGroup(jPDashboardLayout.createSequentialGroup()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconmaxDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCloseDashboard)
                .addContainerGap())
        );
        jPDashboardLayout.setVerticalGroup(
            jPDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDashboardLayout.createSequentialGroup()
                .addGroup(jPDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconmaxDashboard)
                            .addComponent(iconCloseDashboard)
                            .addComponent(iconMinDashboard)))
                    .addGroup(jPDashboardLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14)))
                .addGap(50, 50, 50)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPEmployee.setBackground(new java.awt.Color(255, 255, 255));
        jPEmployee.setPreferredSize(new java.awt.Dimension(633, 41));
        jPEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPEmployeeMouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 102, 255));
        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("MANAGE EMPLOYEE");

        jLabel11.setText("Employee ID");

        txtEID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEIDActionPerformed(evt);
            }
        });

        jLabel12.setText("Employee Name");

        jLabel13.setText("Salary");

        cmbEType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbETypeItemStateChanged(evt);
            }
        });
        cmbEType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbETypeActionPerformed(evt);
            }
        });

        jLabel15.setText("Type");

        btnEmployeeAdd.setBackground(new java.awt.Color(0, 102, 255));
        btnEmployeeAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeAdd.setText("ADD");
        btnEmployeeAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeAddActionPerformed(evt);
            }
        });

        btnEmployeeUpdate.setBackground(new java.awt.Color(0, 102, 255));
        btnEmployeeUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeUpdate.setText("UPDATE");
        btnEmployeeUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeUpdateMouseClicked(evt);
            }
        });

        btnEmployeeDelete.setBackground(new java.awt.Color(0, 102, 255));
        btnEmployeeDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeDelete.setText("DELETE");
        btnEmployeeDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeDeleteMouseClicked(evt);
            }
        });

        btnEmployeeClear.setBackground(new java.awt.Color(0, 102, 255));
        btnEmployeeClear.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeClear.setText("CLEAR");
        btnEmployeeClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeClearActionPerformed(evt);
            }
        });

        jTableEmployee.setBackground(new java.awt.Color(204, 204, 204));
        jTableEmployee.setForeground(new java.awt.Color(0, 102, 255));
        jTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EmpID", "EmpName", "EmpSalary", "EmpType"
            }
        ));
        jTableEmployee.setGridColor(new java.awt.Color(255, 255, 255));
        jTableEmployee.setSelectionBackground(new java.awt.Color(51, 51, 255));
        jTableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmployee);

        btnEmployeeView.setBackground(new java.awt.Color(0, 102, 255));
        btnEmployeeView.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeView.setText("View");
        btnEmployeeView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeViewMouseClicked(evt);
            }
        });

        iconmaxEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maximize.png"))); // NOI18N
        iconmaxEmployee.setToolTipText("Maximize");
        iconmaxEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconmaxEmployeeMouseClicked(evt);
            }
        });

        iconMinEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        iconMinEmployee.setToolTipText("Minimize");
        iconMinEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMinEmployeeMouseClicked(evt);
            }
        });

        iconCloseEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        iconCloseEmployee.setToolTipText("Close");
        iconCloseEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCloseEmployeeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPEmployeeLayout = new javax.swing.GroupLayout(jPEmployee);
        jPEmployee.setLayout(jPEmployeeLayout);
        jPEmployeeLayout.setHorizontalGroup(
            jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmployeeLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPEmployeeLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPEmployeeLayout.createSequentialGroup()
                        .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPEmployeeLayout.createSequentialGroup()
                                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEmployeeAdd)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEname, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtESalary, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnEmployeeUpdate))
                                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPEmployeeLayout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(btnEmployeeDelete))
                                    .addGroup(jPEmployeeLayout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel15))))
                            .addComponent(jLabel12))
                        .addGap(47, 47, 47)
                        .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEType, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPEmployeeLayout.createSequentialGroup()
                                .addComponent(btnEmployeeClear)
                                .addGap(40, 40, 40)
                                .addComponent(btnEmployeeView)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEmployeeLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconMinEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconmaxEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCloseEmployee)
                .addContainerGap())
        );
        jPEmployeeLayout.setVerticalGroup(
            jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmployeeLayout.createSequentialGroup()
                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEmployeeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconmaxEmployee)
                            .addComponent(iconCloseEmployee)
                            .addComponent(iconMinEmployee)))
                    .addGroup(jPEmployeeLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)))
                .addGap(40, 40, 40)
                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cmbEType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(34, 34, 34)
                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtESalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(jPEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmployeeAdd)
                    .addComponent(btnEmployeeUpdate)
                    .addComponent(btnEmployeeDelete)
                    .addComponent(btnEmployeeClear)
                    .addComponent(btnEmployeeView))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPSalary.setBackground(new java.awt.Color(255, 255, 255));
        jPSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPSalaryKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("SALARY CALCULATE");

        jLabel18.setText("Salary ID");

        txtSalAllowance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalAllowanceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalAllowanceKeyReleased(evt);
            }
        });

        jLabel19.setText("Employee Type");

        jLabel20.setText("Employee Name");

        jLabel21.setText("Salary");

        jLabel22.setText("Allowance");

        jLabel23.setText("Monthly Salary");

        btnCalculateSalary.setBackground(new java.awt.Color(0, 102, 255));
        btnCalculateSalary.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculateSalary.setText("Save");
        btnCalculateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateSalaryActionPerformed(evt);
            }
        });

        btnSalaryClear.setBackground(new java.awt.Color(0, 102, 255));
        btnSalaryClear.setForeground(new java.awt.Color(255, 255, 255));
        btnSalaryClear.setText("Clear");
        btnSalaryClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryClearActionPerformed(evt);
            }
        });

        TextAreaPaySheet.setColumns(20);
        jScrollPane1.setViewportView(TextAreaPaySheet);

        btnPaySheet.setBackground(new java.awt.Color(0, 102, 255));
        btnPaySheet.setForeground(new java.awt.Color(255, 255, 255));
        btnPaySheet.setText("PaySheet");
        btnPaySheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaySheetActionPerformed(evt);
            }
        });

        jLabel24.setText("Employee ID");

        cmbSalEmpID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSalEmpIDItemStateChanged(evt);
            }
        });
        cmbSalEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSalEmpIDActionPerformed(evt);
            }
        });

        txtSalEmpType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalEmpTypeActionPerformed(evt);
            }
        });

        txtSalEmpName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalEmpNameActionPerformed(evt);
            }
        });

        txtSalTotalAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSalTotalAmountMouseEntered(evt);
            }
        });

        jLabel25.setText("Total");

        iconMinSalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        iconMinSalary.setToolTipText("Minimize");
        iconMinSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMinSalaryMouseClicked(evt);
            }
        });

        iconmaxSalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maximize.png"))); // NOI18N
        iconmaxSalary.setToolTipText("Maximize");
        iconmaxSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconmaxSalaryMouseClicked(evt);
            }
        });

        iconCloseSalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        iconCloseSalary.setToolTipText("Close");
        iconCloseSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCloseSalaryMouseClicked(evt);
            }
        });

        btnSaveSalPdf.setBackground(new java.awt.Color(0, 102, 255));
        btnSaveSalPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveSalPdf.setText("Save Pdf");
        btnSaveSalPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSalPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPSalaryLayout = new javax.swing.GroupLayout(jPSalary);
        jPSalary.setLayout(jPSalaryLayout);
        jPSalaryLayout.setHorizontalGroup(
            jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSalaryLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnCalculateSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnPaySheet, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalaryClear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPSalaryLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(jLabel18))
                .addGap(25, 25, 25)
                .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSalaryLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconMinSalary)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconmaxSalary)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconCloseSalary))
                    .addGroup(jPSalaryLayout.createSequentialGroup()
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalEmpType, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSalEmpID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalId, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPSalaryLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnSaveSalPdf)))
                        .addGap(0, 198, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPSalaryLayout.setVerticalGroup(
            jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSalaryLayout.createSequentialGroup()
                .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSalaryLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPSalaryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconmaxSalary)
                            .addComponent(iconCloseSalary)
                            .addComponent(iconMinSalary))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPSalaryLayout.createSequentialGroup()
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(10, 10, 10)
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSalEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalEmpType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(btnSaveSalPdf))
                .addGap(32, 32, 32)
                .addGroup(jPSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculateSalary)
                    .addComponent(btnPaySheet)
                    .addComponent(btnSalaryClear))
                .addGap(10, 10, 10))
        );

        jPReport.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setText("REPORTS");

        btnSalaryReport.setBackground(new java.awt.Color(0, 102, 255));
        btnSalaryReport.setForeground(new java.awt.Color(255, 255, 255));
        btnSalaryReport.setText("Get Salary Report");
        btnSalaryReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryReportActionPerformed(evt);
            }
        });

        iconCloseReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        iconCloseReport.setToolTipText("Close");
        iconCloseReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCloseReportMouseClicked(evt);
            }
        });

        iconmaxReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maximize.png"))); // NOI18N
        iconmaxReport.setToolTipText("Maximize");
        iconmaxReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconmaxReportMouseClicked(evt);
            }
        });

        iconMinReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        iconMinReport.setToolTipText("Minimize");
        iconMinReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMinReportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPReportLayout = new javax.swing.GroupLayout(jPReport);
        jPReport.setLayout(jPReportLayout);
        jPReportLayout.setHorizontalGroup(
            jPReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPReportLayout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                .addComponent(iconMinReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconmaxReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCloseReport)
                .addContainerGap())
            .addGroup(jPReportLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(btnSalaryReport, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPReportLayout.setVerticalGroup(
            jPReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPReportLayout.createSequentialGroup()
                .addGroup(jPReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPReportLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPReportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconmaxReport)
                            .addComponent(iconCloseReport)
                            .addComponent(iconMinReport))))
                .addGap(129, 129, 129)
                .addComponent(btnSalaryReport)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jPEmployeeType.setBackground(new java.awt.Color(255, 255, 255));
        jPEmployeeType.setPreferredSize(new java.awt.Dimension(797, 440));
        jPEmployeeType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPEmployeeTypeMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("MANAGE EMPLOYEE TYPE");

        jLabel16.setText("Type ID");

        jLabel17.setText("Type");

        btnETypeAdd.setBackground(new java.awt.Color(0, 102, 255));
        btnETypeAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnETypeAdd.setText("ADD");
        btnETypeAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnETypeAddActionPerformed(evt);
            }
        });

        btnETypeUpdate.setBackground(new java.awt.Color(0, 102, 255));
        btnETypeUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnETypeUpdate.setText("UPDATE");
        btnETypeUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnETypeUpdateActionPerformed(evt);
            }
        });

        btnETypeDelete.setBackground(new java.awt.Color(0, 102, 255));
        btnETypeDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnETypeDelete.setText("DELETE");
        btnETypeDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnETypeDeleteActionPerformed(evt);
            }
        });

        btnETypeClear.setBackground(new java.awt.Color(0, 102, 255));
        btnETypeClear.setForeground(new java.awt.Color(255, 255, 255));
        btnETypeClear.setText("CLEAR");
        btnETypeClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnETypeClearActionPerformed(evt);
            }
        });

        btnETypeView.setBackground(new java.awt.Color(0, 102, 255));
        btnETypeView.setForeground(new java.awt.Color(255, 255, 255));
        btnETypeView.setText("VIEW");
        btnETypeView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnETypeViewMouseClicked(evt);
            }
        });

        jTableEmpType.setBackground(new java.awt.Color(204, 204, 204));
        jTableEmpType.setForeground(new java.awt.Color(0, 51, 255));
        jTableEmpType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "EmpTypeID", "EmpTypeName", "EmpTypeSalary"
            }
        ));
        jTableEmpType.setGridColor(new java.awt.Color(255, 255, 255));
        jTableEmpType.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableEmpType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpTypeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableEmpType);

        txtTypeSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTypeSalaryKeyPressed(evt);
            }
        });

        jLabel26.setText("Salary");

        iconCloseType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        iconCloseType.setToolTipText("Close");
        iconCloseType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCloseTypeMouseClicked(evt);
            }
        });

        iconmaxType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maximize.png"))); // NOI18N
        iconmaxType.setToolTipText("Maximize");
        iconmaxType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconmaxTypeMouseClicked(evt);
            }
        });

        iconMinType.setBackground(new java.awt.Color(0, 0, 0));
        iconMinType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        iconMinType.setToolTipText("Minimize");
        iconMinType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMinTypeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPEmployeeTypeLayout = new javax.swing.GroupLayout(jPEmployeeType);
        jPEmployeeType.setLayout(jPEmployeeTypeLayout);
        jPEmployeeTypeLayout.setHorizontalGroup(
            jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEmployeeTypeLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPEmployeeTypeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addGroup(jPEmployeeTypeLayout.createSequentialGroup()
                        .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPEmployeeTypeLayout.createSequentialGroup()
                                .addComponent(btnETypeAdd)
                                .addGap(40, 40, 40)
                                .addComponent(btnETypeUpdate)
                                .addGap(46, 46, 46)
                                .addComponent(btnETypeDelete)
                                .addGap(35, 35, 35)
                                .addComponent(btnETypeClear))
                            .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTypeSalary, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtTypeName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTypeID, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(36, 36, 36)
                        .addComponent(btnETypeView)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(iconMinType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconmaxType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCloseType))
        );
        jPEmployeeTypeLayout.setVerticalGroup(
            jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmployeeTypeLayout.createSequentialGroup()
                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEmployeeTypeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconmaxType)
                    .addComponent(iconCloseType)
                    .addComponent(iconMinType))
                .addGap(35, 35, 35)
                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEmployeeTypeLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPEmployeeTypeLayout.createSequentialGroup()
                        .addComponent(txtTypeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)))
                .addGroup(jPEmployeeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnETypeAdd)
                    .addComponent(btnETypeUpdate)
                    .addComponent(btnETypeDelete)
                    .addComponent(btnETypeClear)
                    .addComponent(btnETypeView))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPViewLayout = new javax.swing.GroupLayout(jPView);
        jPView.setLayout(jPViewLayout);
        jPViewLayout.setHorizontalGroup(
            jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPEmployeeType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jPViewLayout.setVerticalGroup(
            jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPEmployeeType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPViewLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPmenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPmenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPmenuReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPmenuReportMouseClicked
        jPDashboard.setVisible(false);
        jPEmployee.setVisible(false);
        jPEmployeeType.setVisible(false);
        jPSalary.setVisible(false);
        jPReport.setVisible(true);
        jPmenuAddEmployee.setBackground(Color.LIGHT_GRAY);
        jPmenuAddEmployeeType.setBackground(Color.LIGHT_GRAY);
        jPmenuSalary.setBackground(Color.LIGHT_GRAY);
        jPmenuReport.setBackground(Color.WHITE);
        jPmenuDashboard.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jPmenuReportMouseClicked

    private void jPmenuSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPmenuSalaryMouseClicked
        jPDashboard.setVisible(false);
        jPEmployee.setVisible(false);
        jPEmployeeType.setVisible(false);
        jPSalary.setVisible(true);
        jPReport.setVisible(false);
        
        jPmenuAddEmployee.setBackground(Color.LIGHT_GRAY);
        jPmenuAddEmployeeType.setBackground(Color.LIGHT_GRAY);
        jPmenuSalary.setBackground(Color.WHITE);
        jPmenuReport.setBackground(Color.LIGHT_GRAY);
        jPmenuDashboard.setBackground(Color.LIGHT_GRAY);
        getSalID();
        setSalEmpIDCombo();
    }//GEN-LAST:event_jPmenuSalaryMouseClicked

    private void jPmenuAddEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPmenuAddEmployeeMouseClicked
        jPDashboard.setVisible(false);
        jPEmployee.setVisible(true);
        jPEmployeeType.setVisible(false);
        jPSalary.setVisible(false);
        jPReport.setVisible(false);
        setEmpEmpTypeNameCombo();
        jPmenuAddEmployee.setBackground(Color.WHITE);
        jPmenuAddEmployeeType.setBackground(Color.LIGHT_GRAY);
        jPmenuSalary.setBackground(Color.LIGHT_GRAY);
        jPmenuReport.setBackground(Color.LIGHT_GRAY);
        jPmenuDashboard.setBackground(Color.LIGHT_GRAY);
        getEmpID();
        
        
        
        
    }//GEN-LAST:event_jPmenuAddEmployeeMouseClicked

    private void jPmenuDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPmenuDashboardMouseClicked
        jPDashboard.setVisible(true);
        jPEmployee.setVisible(false);
        jPEmployeeType.setVisible(false);
        jPSalary.setVisible(false);
        jPReport.setVisible(false);
    }//GEN-LAST:event_jPmenuDashboardMouseClicked

    private void jPmenuAddEmployeeTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPmenuAddEmployeeTypeMouseClicked
        jPDashboard.setVisible(false);
        jPEmployee.setVisible(false);
        jPEmployeeType.setVisible(true);
        jPSalary.setVisible(false);
        jPReport.setVisible(false);
        jPmenuAddEmployee.setBackground(Color.LIGHT_GRAY);
        jPmenuAddEmployeeType.setBackground(Color.WHITE);
        jPmenuSalary.setBackground(Color.LIGHT_GRAY);
        jPmenuReport.setBackground(Color.LIGHT_GRAY);
        jPmenuDashboard.setBackground(Color.LIGHT_GRAY);
        getEmpTypeID();
        
    }//GEN-LAST:event_jPmenuAddEmployeeTypeMouseClicked

    private void txtEIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEIDActionPerformed

    private void btnEmployeeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeAddActionPerformed
        if(txtEID.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Empolyee ID Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(txtEname.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Empolyee Name Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(!txtEname.getText().matches("[a-zA-Z]+$+"))
       {
            JOptionPane.showMessageDialog(this,"Empolyee Name Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);
            
       }
       else if(txtESalary.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Empolyee Salary Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }

     
       else{
           try{
               Employee employee = new Employee(txtEID.getText(),txtEname.getText(),txtESalary.getText(),cmbEType.getSelectedItem().toString());
               ManageEmployee employee1=new ManageEmployee(employee);
               employee1.saveEmployee();
               EmpClear();
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
       }
    }//GEN-LAST:event_btnEmployeeAddActionPerformed

    private void cmbETypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbETypeActionPerformed
       
    }//GEN-LAST:event_cmbETypeActionPerformed

    private void jPEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPEmployeeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPEmployeeMouseClicked

    private void btnCalculateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateSalaryActionPerformed
       if(txtSalId.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Salary ID Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(txtSalSalary.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Salary  Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(txtSalAllowance.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Allowance Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(txtSalEmpType.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Employee Type Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       
       else if(!txtSalEmpType.getText().matches("[a-zA-Z]+$"))
       {
            JOptionPane.showMessageDialog(this,"Employee Type Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);    
       }
       else if(txtSalEmpName.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Employee Name Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(!txtSalEmpName.getText().matches("[a-zA-Z]+$"))
       {
            JOptionPane.showMessageDialog(this,"Employee Name Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);    
       }
      
       
       
       else{
           try{
               
               if(txtSalEmpType.getText().equals("Employee")){
               EmployeeSal esalary =new EmployeeSal();
               esalary.getData();
               esalary.Calculate();
               esalary.setData();
               setSalEmpTotalSalary();
               
               
               }
               
               else if(txtSalEmpType.getText().equals("Manager")){
                   
               ManagerSal msalary =new ManagerSal();
               msalary.getData();
               msalary.Calculate();
               msalary.setData();
               setSalEmpTotalSalary();
               
               
               }
               
               else if(txtSalEmpType.getText().equals("Caretaker")){
                   
               CaretakerSal csalary =new CaretakerSal();
               csalary.getData();
               csalary.Calculate();
               csalary.setData();
               setSalEmpTotalSalary();
               
               
               }
               
               else if(txtSalEmpType.getText().equals("Security")){
                   
               SecuritySal ssalary =new SecuritySal();
               ssalary.getData();
               ssalary.Calculate();
               ssalary.setData();
               setSalEmpTotalSalary();
               
               
               }
    
   
               
            }
           
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
       }
        
        //AddBill();
        
       
       
    }//GEN-LAST:event_btnCalculateSalaryActionPerformed

    private void txtSalAllowanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalAllowanceKeyReleased
        calculateTotalSalary();
    }//GEN-LAST:event_txtSalAllowanceKeyReleased

    private void btnPaySheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaySheetActionPerformed
      CreatPaySheet();
        
    }//GEN-LAST:event_btnPaySheetActionPerformed

    private void btnEmployeeViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeViewMouseClicked
        viewEmployee();
    }//GEN-LAST:event_btnEmployeeViewMouseClicked

    private void jTableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmployeeMouseClicked
       try{
        DefaultTableModel model=(DefaultTableModel)jTableEmployee.getModel();
        int tableIndex=jTableEmployee.getSelectedRow();
        txtEID.setText(model.getValueAt(tableIndex, 0).toString());
        txtEname.setText(model.getValueAt(tableIndex, 1).toString());
        txtESalary.setText(model.getValueAt(tableIndex, 2).toString());
        cmbEType.removeAllItems();
        cmbEType.addItem(model.getValueAt(tableIndex, 3).toString());
       }
         catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
      
        
    }//GEN-LAST:event_jTableEmployeeMouseClicked

    private void btnEmployeeUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeUpdateMouseClicked
        
       if(txtEID.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Empolyee ID Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(txtEname.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Empolyee Name Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(!txtEname.getText().matches("[a-zA-Z]+$"))
       {
            JOptionPane.showMessageDialog(this,"Empolyee Name Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);
            
       }
       else if(txtESalary.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Empolyee Salary Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }

     
       else{
           try{
               Employee employee = new Employee(txtEID.getText(),txtEname.getText(),txtESalary.getText(),cmbEType.getSelectedItem().toString());
               ManageEmployee employee1=new ManageEmployee(employee);
               employee1.UpdateEmployee();
               EmpClear();
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        
       }
    }//GEN-LAST:event_btnEmployeeUpdateMouseClicked

    private void btnEmployeeDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeDeleteMouseClicked
      
           
       if(txtEID.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Empolyee ID Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(txtEname.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Empolyee Name Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if(!txtEname.getText().matches("[a-zA-Z]+$"))
       {
            JOptionPane.showMessageDialog(this,"Empolyee Name Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);
            
       }
       else if(txtESalary.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Empolyee Salary Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
       }

     
       else{
           try{
                Employee employee = new Employee(txtEID.getText(),txtEname.getText(),txtESalary.getText(),cmbEType.getSelectedItem().toString());
                ManageEmployee employee1=new ManageEmployee(employee);
                employee1.DeleteEmployee();
                EmpClear();
           }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        
       }
    }//GEN-LAST:event_btnEmployeeDeleteMouseClicked

    private void btnEmployeeClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeClearActionPerformed
      
        EmpClear();
        
    }//GEN-LAST:event_btnEmployeeClearActionPerformed

    private void btnSalaryClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaryClearActionPerformed
 
        BillClear();
                 
    }//GEN-LAST:event_btnSalaryClearActionPerformed

    private void cmbSalEmpIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSalEmpIDItemStateChanged
        setSalEmpSalary();
        
        setSalEmpType();
        setSalEmpName();
    }//GEN-LAST:event_cmbSalEmpIDItemStateChanged

    private void cmbSalEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSalEmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSalEmpIDActionPerformed

    private void cmbETypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbETypeItemStateChanged
        setEmpSalary();
    }//GEN-LAST:event_cmbETypeItemStateChanged

    //Connection con;
    //PreparedStatement pst;  
    private void btnSalaryReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaryReportActionPerformed
          try{
              
            Connection con= Database.createConnection();
            
            String rs = "SELECT * FROM empsalary";
            
            JasperDesign jdesign=JRXmlLoader.load("C:\\Users\\malith\\Documents\\NetBeansProjects\\SalaryManagement\\src\\view\\reportSalary.jrxml");
            
              JRDesignQuery UpdateQuery= new JRDesignQuery();
              UpdateQuery.setText(rs);
              
              jdesign.setQuery(UpdateQuery);
              JasperReport jreport=JasperCompileManager.compileReport(jdesign);
              JasperPrint jprint = JasperFillManager.fillReport(jreport, null,con);
              
              JasperViewer.viewReport(jprint);
            
          }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Database Error!", JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnSalaryReportActionPerformed

    int xx,xy;
    private void jPmenuItemMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPmenuItemMouseDragged
         int x,y;
         x=evt.getXOnScreen();
         y=evt.getYOnScreen();
         this.setLocation(x-xx,y-xy);
         
    }//GEN-LAST:event_jPmenuItemMouseDragged

    private void jPmenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPmenuItemMousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jPmenuItemMousePressed

    public void Close(){
        this.dispose();
    }
    public void Minimize(){
        this.setExtendedState(this.ICONIFIED);
    
    }
    public void Maximize(){
        if(this.getExtendedState()!=this.MAXIMIZED_BOTH){
            this.setExtendedState(this.MAXIMIZED_BOTH);
        }
        else{
            this.setExtendedState(NORMAL);
        }
    
    }
    
    
        
    
    private void iconCloseDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCloseDashboardMouseClicked
        this.Close();
    }//GEN-LAST:event_iconCloseDashboardMouseClicked

    private void iconmaxDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconmaxDashboardMouseClicked
        Maximize();
    }//GEN-LAST:event_iconmaxDashboardMouseClicked

    private void iconMinDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMinDashboardMouseClicked
        Minimize();
    }//GEN-LAST:event_iconMinDashboardMouseClicked

    private void iconmaxEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconmaxEmployeeMouseClicked
         Maximize();
    }//GEN-LAST:event_iconmaxEmployeeMouseClicked

    private void iconMinEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMinEmployeeMouseClicked
        Minimize();
    }//GEN-LAST:event_iconMinEmployeeMouseClicked

    private void iconCloseEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCloseEmployeeMouseClicked
        this.Close();
    }//GEN-LAST:event_iconCloseEmployeeMouseClicked

    private void iconMinSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMinSalaryMouseClicked
         Minimize();
    }//GEN-LAST:event_iconMinSalaryMouseClicked

    private void iconmaxSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconmaxSalaryMouseClicked
         Maximize();
    }//GEN-LAST:event_iconmaxSalaryMouseClicked

    private void iconCloseSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCloseSalaryMouseClicked
         this.Close();
    }//GEN-LAST:event_iconCloseSalaryMouseClicked

    private void iconCloseReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCloseReportMouseClicked
        this.Close();
    }//GEN-LAST:event_iconCloseReportMouseClicked

    private void iconmaxReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconmaxReportMouseClicked
        Maximize();
    }//GEN-LAST:event_iconmaxReportMouseClicked

    private void iconMinReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMinReportMouseClicked
        Minimize();
    }//GEN-LAST:event_iconMinReportMouseClicked

    private void jPEmployeeTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPEmployeeTypeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPEmployeeTypeMouseClicked

    private void iconMinTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMinTypeMouseClicked
        Minimize();
    }//GEN-LAST:event_iconMinTypeMouseClicked

    private void iconmaxTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconmaxTypeMouseClicked
        Maximize();
    }//GEN-LAST:event_iconmaxTypeMouseClicked

    private void iconCloseTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCloseTypeMouseClicked
        this.Close();
    }//GEN-LAST:event_iconCloseTypeMouseClicked

    private void jTableEmpTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpTypeMouseClicked
        try{
            DefaultTableModel model=(DefaultTableModel)jTableEmpType.getModel();
            int tableIndex=jTableEmpType.getSelectedRow();
            txtTypeID.setText(model.getValueAt(tableIndex, 0).toString());
            txtTypeName.setText(model.getValueAt(tableIndex, 1).toString());
            txtTypeSalary.setText(model.getValueAt(tableIndex, 2).toString());
        
         }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jTableEmpTypeMouseClicked

    private void btnETypeViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnETypeViewMouseClicked
        viewEmpType();
    }//GEN-LAST:event_btnETypeViewMouseClicked

    private void btnETypeClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnETypeClearActionPerformed

        EmpTypeClear();
    }//GEN-LAST:event_btnETypeClearActionPerformed

    private void btnETypeDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnETypeDeleteActionPerformed
        {
        if(txtTypeID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type ID Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(txtTypeName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type Name Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(!txtTypeName.getText().matches("[a-zA-Z]+$"))
       {
            JOptionPane.showMessageDialog(this,"Empolyee Type Name Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);
            
       }
        else if(txtTypeSalary.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type Salary Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
        else{
            try{
                EmployeeType employeetype = new EmployeeType(txtTypeID.getText(),txtTypeName.getText(),txtTypeSalary.getText());
                ManageEmployeeType employeetype1=new ManageEmployeeType(employeetype);
                employeetype1.DeleteEmployeeType();
            
         }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        }

    }                                                                                       
        
    }//GEN-LAST:event_btnETypeDeleteActionPerformed

    private void btnETypeUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnETypeUpdateActionPerformed
        
        if(txtTypeID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type ID Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(txtTypeName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type Name Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(!txtTypeName.getText().matches("[a-zA-Z]+$"))
       {
            JOptionPane.showMessageDialog(this,"Empolyee Type Name Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);
            
       }
        else if(txtTypeSalary.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type Salary Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
        else{
            try{
                EmployeeType employeetype = new EmployeeType(txtTypeID.getText(),txtTypeName.getText(),txtTypeSalary.getText());
                ManageEmployeeType employeetype1=new ManageEmployeeType(employeetype);
                employeetype1.UpdateEmployeeType();
                EmpTypeClear();
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        }
    
    }//GEN-LAST:event_btnETypeUpdateActionPerformed

    private void btnETypeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnETypeAddActionPerformed
        
        if(txtTypeID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type ID Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(txtTypeName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type Name Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(!txtTypeName.getText().matches("[a-zA-Z]+$"))
       {
            JOptionPane.showMessageDialog(this,"Empolyee Type Name Cannot be Numeric","Warning",JOptionPane.WARNING_MESSAGE);
            
       }
        else if(txtTypeSalary.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Empolyee Type Salary Cannot Be Blank!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
        else{
            try{
                EmployeeType employeetype = new EmployeeType(txtTypeID.getText(),txtTypeName.getText(),txtTypeSalary.getText());
                ManageEmployeeType employeetype1=new ManageEmployeeType(employeetype);
                employeetype1.saveEmployeeType();
                EmpTypeClear();
             }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        } 
    }//GEN-LAST:event_btnETypeAddActionPerformed

    private void txtSalEmpNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalEmpNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalEmpNameActionPerformed

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
       this.dispose();
       new Login().setVisible(true);
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void txtTypeSalaryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeSalaryKeyPressed
      char c =evt.getKeyChar();
      if(Character.isLetter(c)){
          
          JOptionPane.showMessageDialog(this, "Empolyee Type Salary Cannot Include Letters!","Warning",JOptionPane.WARNING_MESSAGE);
          txtTypeSalary.setText(null);
      }
      
      else{
              txtTypeSalary.setEditable(true);
       }
    }//GEN-LAST:event_txtTypeSalaryKeyPressed

    private void txtSalAllowanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalAllowanceKeyPressed
      char c =evt.getKeyChar();
      if(Character.isLetter(c)){
          
          JOptionPane.showMessageDialog(this, "Salary Allowance Cannot Include Letters!","Warning",JOptionPane.WARNING_MESSAGE);
         txtSalAllowance.setText(null);
      }
      
      else{
              txtSalAllowance.setEditable(true);
       }
    }//GEN-LAST:event_txtSalAllowanceKeyPressed

    private void txtSalEmpTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalEmpTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalEmpTypeActionPerformed

    private void jPSalaryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPSalaryKeyPressed
        
    }//GEN-LAST:event_jPSalaryKeyPressed

    private void jPmenuSalaryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPmenuSalaryKeyPressed
       
    }//GEN-LAST:event_jPmenuSalaryKeyPressed

    private void txtSalTotalAmountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalTotalAmountMouseEntered
         txtSalTotalAmount.setEditable(false);
    }//GEN-LAST:event_txtSalTotalAmountMouseEntered

    private void btnSaveSalPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSalPdfActionPerformed
        try{
           Document doc = new Document();
           
           
           PdfWriter.getInstance(doc, new FileOutputStream("Salary.pdf"));
           doc.open();
           doc.add(new Paragraph(TextAreaPaySheet.getText()));
           doc.close();
           JOptionPane.showMessageDialog(this, "Pdf File Saved!","Info",JOptionPane.INFORMATION_MESSAGE );
       }

        catch(DocumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }  
        
        
    }//GEN-LAST:event_btnSaveSalPdfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextAreaPaySheet;
    private javax.swing.JButton btnCalculateSalary;
    private javax.swing.JButton btnETypeAdd;
    private javax.swing.JButton btnETypeClear;
    private javax.swing.JButton btnETypeDelete;
    private javax.swing.JButton btnETypeUpdate;
    private javax.swing.JButton btnETypeView;
    private javax.swing.JButton btnEmployeeAdd;
    private javax.swing.JButton btnEmployeeClear;
    private javax.swing.JButton btnEmployeeDelete;
    private javax.swing.JButton btnEmployeeUpdate;
    private javax.swing.JButton btnEmployeeView;
    private javax.swing.JButton btnPaySheet;
    private javax.swing.JButton btnSalaryClear;
    private javax.swing.JButton btnSalaryReport;
    private javax.swing.JButton btnSaveSalPdf;
    private javax.swing.JComboBox<String> cmbEType;
    private javax.swing.JComboBox<String> cmbSalEmpID;
    private javax.swing.JLabel iconCloseDashboard;
    private javax.swing.JLabel iconCloseEmployee;
    private javax.swing.JLabel iconCloseReport;
    private javax.swing.JLabel iconCloseSalary;
    private javax.swing.JLabel iconCloseType;
    private javax.swing.JLabel iconMinDashboard;
    private javax.swing.JLabel iconMinEmployee;
    private javax.swing.JLabel iconMinReport;
    private javax.swing.JLabel iconMinSalary;
    private javax.swing.JLabel iconMinType;
    private javax.swing.JLabel iconmaxDashboard;
    private javax.swing.JLabel iconmaxEmployee;
    private javax.swing.JLabel iconmaxReport;
    private javax.swing.JLabel iconmaxSalary;
    private javax.swing.JLabel iconmaxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPDashboard;
    private javax.swing.JPanel jPEmployee;
    private javax.swing.JPanel jPEmployeeType;
    private javax.swing.JPanel jPReport;
    private javax.swing.JPanel jPSalary;
    private javax.swing.JPanel jPView;
    private javax.swing.JPanel jPmenuAddEmployee;
    private javax.swing.JPanel jPmenuAddEmployeeType;
    private javax.swing.JPanel jPmenuDashboard;
    private javax.swing.JPanel jPmenuItem;
    private javax.swing.JPanel jPmenuReport;
    private javax.swing.JPanel jPmenuSalary;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableEmpType;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtEID;
    private javax.swing.JTextField txtESalary;
    private javax.swing.JTextField txtEname;
    private javax.swing.JTextField txtSalAllowance;
    private javax.swing.JTextField txtSalEmpName;
    private javax.swing.JTextField txtSalEmpType;
    private javax.swing.JTextField txtSalId;
    private javax.swing.JTextField txtSalSalary;
    private javax.swing.JTextField txtSalTotal;
    private javax.swing.JTextField txtSalTotalAmount;
    private javax.swing.JTextField txtTypeID;
    private javax.swing.JTextField txtTypeName;
    private javax.swing.JTextField txtTypeSalary;
    // End of variables declaration//GEN-END:variables

}
