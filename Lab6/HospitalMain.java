import java.util.ArrayList;
import java.util.List;

abstract class Hospital {
    private String name;
    private String address;
    private List<Patients> patients;
    private List<department> departments;

    public Hospital() {
        this.patients = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    public String getname() { return name; }
    public String getaddress() { return address; }
    public List<Patients> getpatients() { return patients; }
    public List<department> getdepartments() { return departments; }

    public void setname(String name) { this.name = name; }
    public void setaddress(String address) { this.address = address; }

    public void addPatient(Patients p) { patients.add(p); }
    public void removePatient(Patients p) { patients.remove(p); }

    class department {
        private String name;
        private List<TeamMember> staff;

        public department() {
            this.staff = new ArrayList<>();
        }

        public String getname() { return name; }
        public List<TeamMember> getstaff() { return staff; }

        public void setname(String name) { this.name = name; }

        public void addTeamMember(TeamMember tm) { staff.add(tm); }
        public void removeTeamMember(TeamMember tm) { staff.remove(tm); }
    }
}

class TeamMember extends Hospital {
    private String name;
    private long id;
    private String gender;
    private String dateOfJoining;
    int maxWorkingHours = 12;

    public String getname() { return name; }
    public long getid() { return id; }
    public String getgender() { return gender; }
    public String getdateOfJoining() { return dateOfJoining; }

    public void setname(String name) { this.name = name; }
    public void setid(long id) { this.id = id; }
    public void setgender(String gender) { this.gender = gender; }
    public void setdateOfJoining(String dateOfJoining) { this.dateOfJoining = dateOfJoining; }
}

abstract class Doctor extends TeamMember {
    private String specialty;

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public void checkPatientReport(Patients p) {
        System.out.println("Checking report for patient: " + p.getname());
        System.out.println("Diagnosis: " + p.getDiagnosis());
        System.out.println("Treating Doctor: " + p.getTreatingDoctor().getname());
    }

    public abstract void treatPatient();
}

class Intern extends Doctor {
    private SeniorDoctor supervisor;

    public SeniorDoctor getsupervisor() { return supervisor; }
    public void setsupervisor(SeniorDoctor supervisor) { this.supervisor = supervisor; }

    @Override
    public void treatPatient() {
        System.out.println("Intern is treating patient under supervision of " + supervisor.getname());
    }
}

class SeniorDoctor extends Doctor {
    private List<Patients> patients;

    public SeniorDoctor() {
        this.patients = new ArrayList<>();
    }

    public List<Patients> getpatients() { return patients; }
    public void addPatient(Patients p) { patients.add(p); }
    public void removePatient(Patients p) { patients.remove(p); }

    @Override
    public void treatPatient() {
        System.out.println("Senior Doctor is treating patient.");
    }
}
class Surgeon extends Doctor {
    private List<Patients> patients;

    public Surgeon() {
        this.patients = new ArrayList<>();
    }
    public List<Patients> getpatients() { return patients; }
    public void addPatient(Patients p) { patients.add(p); }
    public void removePatient(Patients p) { patients.remove(p); }

    @Override
    public void treatPatient() {
        System.out.println("Surgeon is performing surgery on patient.");
    }
}
class Nurse extends TeamMember {
}
class Patients extends Hospital {
    private String name;
    private String dob;
    private String gender;
    private String admitDate;
    private int daysLeftInHospital;
    private String diagnosis;
    private Doctor treatingDoctor;

    public String getname() { return name; }
    public String getdob() { return dob; }
    public String getgender() { return gender; }
    public String getadmitDate() { return admitDate; }
    public int getdaysLeftInHospital() { return daysLeftInHospital; }
    public String getDiagnosis() { return diagnosis; }
    public Doctor getTreatingDoctor() { return treatingDoctor; }

    public void setname(String name) { this.name = name; }
    public void setdob(String dob) { this.dob = dob; }
    public void setgender(String gender) { this.gender = gender; }
    public void setadmitDate(String admitDate) { this.admitDate = admitDate; }
    public void setdaysLeftInHospital(int daysLeftInHospital) { this.daysLeftInHospital = daysLeftInHospital; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setTreatingDoctor(Doctor treatingDoctor) { this.treatingDoctor = treatingDoctor; }
}

public class HospitalMain {
    public static void main(String[] args) {
        Patients p1 = new Patients();
        p1.setname("Sharukh Khan");
        p1.setdob("2000-01-15");
        p1.setgender("male");
        p1.setadmitDate("2025-02-01");
        p1.setdaysLeftInHospital(5);
        p1.setDiagnosis("Fractured leg");

        SeniorDoctor sd = new SeniorDoctor();
        sd.setname("Dr. Zaynab");
        sd.setSpecialty("General Medicine");
        sd.addPatient(p1);
        p1.setTreatingDoctor(sd);

        Intern intern = new Intern();
        intern.setname("Dr. Ahmed");
        intern.setsupervisor(sd);

        Surgeon surgeon = new Surgeon();
        surgeon.setname("Dr. Ayesha");
        surgeon.setSpecialty("Cardiothoracic");
        surgeon.addPatient(p1);

        sd.treatPatient();
        System.out.println("---------------------------------");
        intern.treatPatient();
        System.out.println("---------------------------------");
        surgeon.treatPatient();
        System.out.println("---------------------------------");
        sd.checkPatientReport(p1);
        System.out.println("---------------------------------");
    }
}