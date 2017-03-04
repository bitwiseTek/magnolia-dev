package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.support.EntityBuilder.EntityBuilderManager;
import com.bitwise.magnolia.model.user.User;

public class InitialDataSetup {
	
	public InitialDataSetup(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@PersistenceContext
	private EntityManager em;
	
	private Permission permissionEditProfile = new Permission("PERMISSION_EDIT_PROFILE");
	private Permission permissionEditCourses = new Permission("PERMISSION_EDIT_COURSES");
	private Permission permissionAddCourses = new Permission("PERMISSION_ADD_COURSES");
	private Permission permissionAttachCourses = new Permission("PERMISSION_ATTACH_COURSES");
	private Permission permissionEditUsers = new Permission("PERMISSION_EDIT_USERS");
	private Permission permissionGenerateResult = new Permission("PERMISSION_GENERATE_RESULT");
	private Permission permissionEditResult = new Permission("PERMISSION_EDIT_RESULT");
	private Permission permissionEditAccommodation = new Permission("PERMISSION_EDIT_ACCOMMODATION");
	private Permission permissionEditGrades = new Permission("PERMISSION_EDIT_GRADES");

	private Role roleSuperAdmin = new Role("ROLE_SUPER_ADMIN");
	private Role roleAdmin = new Role("ROLE_ADMINISTRATOR");
	private Role roleStudent = new Role("ROLE_STUDENT");
	private Role roleStaff = new Role("ROLE_STAFF");
	private Role roleLecturer = new Role("ROLE_LECTURER");
	private Role roleHod = new Role("ROLE_HOD");
	private Role roleDean = new Role("ROLE_DEAN");
	private Role roleManager = new Role("ROLE_MANAGER");
	private Role roleAccountant = new Role("ROLE_ACCOUNTANT");
	
	private AcademicSemester academiSemester;
	
	private Campus campus;
	
	private Course course;
	
	private CourseLength courseLength;
	
	private Department department;
	
	private Faculty faculty;
	
	private LGA lga;
	
	private School school;
	
	private Staff staff;
	
	private State state;
	
	private Student student;
	
	private StudyProgramme studyProgramme;
	
	private StudyProgrammeCategory studyProgrammeCategory;
	
	private SubSchool subSchool;
	
	private User user;
	
	private TransactionTemplate transactionTemplate;
	
	public void initialize() {
		EntityBuilderManager.setEntityManager(em);
		this.transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus status) {
				if (dataIsAlreadyPresent()) {
					return null;
				}
				
				//Tables Creation
				//State
				{
					InitialDataSetup.this.state = new StateBuilder() {
						{
							state("Rivers");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Abia");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Adamawa");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Akwa-Ibom");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Anambra");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Bauchi");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Bayelsa");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Benue");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Borno");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Cross-River");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Delta");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Ebonyi");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Edo");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Enugu");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Ekiti");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("F.C.T");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Gombe");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Imo");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Jigawa");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Kaduna");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Kano");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Katsina");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Kebbi");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Kogi");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Kwara");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Lagos");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Nasarawa");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Niger");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Ogun");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Osun");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Oyo");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Plateau");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Sokoto");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Taraba");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Yobe");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Zamfara");
						}
					}.build();
					
					new StateBuilder() {
						{
							state("Ondo");
						}
					}.build();
					
				}
				
				//LGA
				{
					InitialDataSetup.this.lga = new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Port-Harcourt");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Obio-Akpor");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Ogu-Bolo");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Eleme");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Gokana");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Khana");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Oyigbo");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Opobo-Nkoro");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Andoni");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Bonny");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Degema");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Asari-Toru");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Akuku-Toru");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Abua-Odual");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Ahoada-West");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Ahoada-East");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Ogba-Egbema-Ndoni");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Emuoha");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Ikwerre");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Omuma");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Okrika");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Etche");
						}
					}.build();
					
					new LGABuilder() {
						{
							state(InitialDataSetup.this.state);
							lga("Tai");
						}
					}.build();
				}
				
				//User
				{
					InitialDataSetup.this.user = new UserBuilder() {
						{
							name("Kalada", "Sika", "Tamunoemi");
							state(InitialDataSetup.this.state);
							lga(InitialDataSetup.this.lga);
							userDetails(Utils.getCustomString(10, ""), Utils.getSexes().get("ML"), ApplicationConstant.ACTIVE_STATUS, "No 9D Nzimiro Street, Old GRA", "07083472155", "08035504051", "sika.kayy@gmail.com", null, "05/04/1989", "photo");
							credentials("superadmin@magnoliacad.com", "$2a$10$aqNY.kMd1h2u1MbK2JUA8./3g2VM.BAB09kzHFpz6b6NQ57PBn/fy", "magnolia", Utils.getQuestions().get("Q1"), "Elizabeth", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), Utils.generateUUID());
							roleWithPermissions(InitialDataSetup.this.roleSuperAdmin,
									InitialDataSetup.this.permissionEditProfile,
									InitialDataSetup.this.permissionEditUsers,
									InitialDataSetup.this.permissionEditAccommodation,
									InitialDataSetup.this.permissionEditGrades);
						}
					}.build();
					
					new UserBuilder() {
						{
							name("Success", "Otto", "Joseph");
							state(InitialDataSetup.this.state);
							lga(InitialDataSetup.this.lga);
							userDetails(Utils.getCustomString(10, ""), Utils.getSexes().get("ML"), ApplicationConstant.ACTIVE_STATUS, "Bangladesh, India", "+918867872801", null, "joseph.success@yahoo.com", null, "02/09/1992", "photo");
							credentials("admin@magnoliacad.com", "$2a$10$aqNY.kMd1h2u1MbK2JUA8./3g2VM.BAB09kzHFpz6b6NQ57PBn/fy", "magnolia", Utils.getQuestions().get("Q1"), "Elizabeth", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), Utils.generateUUID());
							roleWithPermissions(InitialDataSetup.this.roleAdmin,
									InitialDataSetup.this.permissionEditProfile,
									InitialDataSetup.this.permissionEditUsers,
									InitialDataSetup.this.permissionEditAccommodation);
						}
					}.build();
					
					new UserBuilder() {
						{
							name("Jeffery", "Atkins", "Turaya");
							state(InitialDataSetup.this.state);
							lga(InitialDataSetup.this.lga);
							userDetails(Utils.getCustomString(10, ""), Utils.getSexes().get("ML"), ApplicationConstant.PENDING_STATUS, "Bangladesh, India", "+918867873212", null, "jeff.atkins@yahoo.com", null, "02/02/1994", "photo");
							credentials("jeffery.atkins@magnoliacad.com", "$2a$10$aqNY.kMd1h2u1MbK2JUA8./3g2VM.BAB09kzHFpz6b6NQ57PBn/fy", "magnolia", Utils.getQuestions().get("Q1"), "Elizabeth", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), Utils.generateUUID());
							roleWithPermissions(InitialDataSetup.this.roleStudent,
									InitialDataSetup.this.permissionEditProfile,
									InitialDataSetup.this.permissionEditCourses,
									InitialDataSetup.this.permissionAddCourses,
									InitialDataSetup.this.permissionGenerateResult);
						}
					}.build();
					
					new UserBuilder() {
						{
							name("Eteng", "Omah", "Nkanem");
							state(InitialDataSetup.this.state);
							lga(InitialDataSetup.this.lga);
							userDetails(Utils.getCustomString(10, ""), Utils.getSexes().get("ML"), ApplicationConstant.PENDING_STATUS, "Bangladesh, India", "+918867873876", null, "eteng.omah@yahoo.com", null, "12/03/1976", "photo");
							credentials("eteng.omah@magnoliacad.com", "$2a$10$aqNY.kMd1h2u1MbK2JUA8./3g2VM.BAB09kzHFpz6b6NQ57PBn/fy", "magnolia", Utils.getQuestions().get("Q1"), "Elizabeth", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), Utils.generateUUID());
							roleWithPermissions(InitialDataSetup.this.roleStaff,
									InitialDataSetup.this.permissionEditProfile,
									InitialDataSetup.this.permissionEditCourses,
									InitialDataSetup.this.permissionAttachCourses,
									InitialDataSetup.this.permissionEditGrades,
									InitialDataSetup.this.permissionEditResult);
						}
					}.build();
				}
				
				//School
				{
					InitialDataSetup.this.school = new SchoolBuilder() {
						{
							school("info@magnoliacad.com", "Choba", ApplicationConstant.SCHOOL_ALIAS, "https://magnoliacad.com", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), 365, "logo", "Magnolia", "a5ukhxhEObzv8TBW8yxeNYy6hm1knu", ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
				}
				
				//SubSchool
				{
					InitialDataSetup.this.subSchool = new SubSchoolBuilder() {
						{
							school(InitialDataSetup.this.school);
							subSchool("School of Undergraduate Studies", "Academic", "Choba", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
					
					new SubSchoolBuilder() {
						{
							school(InitialDataSetup.this.school);
							subSchool("School of Graduate Studies", "Academic", "Choba", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
				}
				
				//Campus
				{
					InitialDataSetup.this.campus = new CampusBuilder() {
						{
							subSchool(InitialDataSetup.this.subSchool);
							campus("Abuja", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
					
					new CampusBuilder() {
						{
							subSchool(InitialDataSetup.this.subSchool);
							campus("Choba", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
				}
				
				//Faculty
				{
					InitialDataSetup.this.faculty = new FacultyBuilder() {
						{
							campus(InitialDataSetup.this.campus);
							faculty("Faculty of Engineering", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
					
					new FacultyBuilder() {
						{
							campus(InitialDataSetup.this.campus);
							faculty("Faculty of Sciences", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
				}
				
				//Department
				{
					InitialDataSetup.this.department = new DepartmentBuilder() {
						{
							faculty(InitialDataSetup.this.faculty);
							department("Department of Electrical/Electronics Engineering", "3015", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
					
					new DepartmentBuilder() {
						{
							faculty(InitialDataSetup.this.faculty);
							department("Department of Petroleum Engineering", "3065", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
					
					new DepartmentBuilder() {
						{
							faculty(InitialDataSetup.this.faculty);
							department("Department of Mathematics and Statistics", "2025", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
				}
				
				//AcademicSemester
				{
					InitialDataSetup.this.academiSemester = new AcademicSemesterBuilder() {
						{
							semester("1st Semester", "2016/2017", new DateTime(DateTime.now()), new DateTime(DateTime.now()).plusDays(90), new DateTime(DateTime.now()));
						}
					}.build();
					
					new AcademicSemesterBuilder() {
						{
							semester("2nd Semester", "2016/2017", new DateTime(DateTime.now().plusDays(90)), new DateTime(DateTime.now()).plusDays(180), new DateTime(DateTime.now()));
						}
					}.build();
				}
				
				//CourseLength
				{
					InitialDataSetup.this.courseLength = new CourseLengthBuilder() {
						{
							courseLength("ENG-5", 366, 2880);
						}
					}.build();
					
					new CourseLengthBuilder() {
						{
							courseLength("SCI-4", 150, 2304);
						}
					}.build();
				}
				
				//StudyProgrammeCategory
				{
					InitialDataSetup.this.studyProgrammeCategory = new StudyProgrammeCategoryBuilder() {
						{
							category("Taught Programme (Full-Time)", new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
					
					new StudyProgrammeCategoryBuilder() {
						{
							category("Taught Programme (Part-Time)",  new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
					
					new StudyProgrammeCategoryBuilder() {
						{
							category("Research Programme",  new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date()), ApplicationConstant.ACTIVE_STATUS);
						}
					}.build();
				}
				
				//StudyProgramme
				{
					InitialDataSetup.this.studyProgramme = new StudyProgrammeBuilder() {
						{
							category(InitialDataSetup.this.studyProgrammeCategory);
							courseLength(InitialDataSetup.this.courseLength);
							department(InitialDataSetup.this.department);
							user(InitialDataSetup.this.user, InitialDataSetup.this.user);
							programme("Electrical/Electronics Engineering", ApplicationConstant.ACTIVE_STATUS, "EEE", "Programme on the Engineering discipline known for its application on Electricity and its related concepts", 
									200, 200, new DateTime(DateTime.now()), new DateTime(DateTime.now()), 1825, new DateTime(DateTime.now()).plusDays(1825));
						}
					}.build();
					
					new StudyProgrammeBuilder() {
						{
							category(InitialDataSetup.this.studyProgrammeCategory);
							courseLength(InitialDataSetup.this.courseLength);
							department(InitialDataSetup.this.department);
							user(InitialDataSetup.this.user, InitialDataSetup.this.user);
							programme("Petroleum Engineering", ApplicationConstant.ACTIVE_STATUS, "PNG", "Programme on the Engineering discipline known for its application on Crude Oil and its related concepts", 
									200, 200, new DateTime(DateTime.now()), new DateTime(DateTime.now()), 1825, new DateTime(DateTime.now()).plusDays(1825));
						}
					}.build();
					
					new StudyProgrammeBuilder() {
						{
							category(InitialDataSetup.this.studyProgrammeCategory);
							courseLength(InitialDataSetup.this.courseLength);
							department(InitialDataSetup.this.department);
							user(InitialDataSetup.this.user, InitialDataSetup.this.user);
							programme("Computer Science", ApplicationConstant.ACTIVE_STATUS, "CSC", "Programme on the Mathematics & Science discipline known for its application on Processor-based architecture and its related concepts", 
									200, 200, new DateTime(DateTime.now()), new DateTime(DateTime.now()), 1460, new DateTime(DateTime.now()).plusDays(1460));
						}
					}.build();
				}
				
				//Staff
				{
					InitialDataSetup.this.staff = new StaffBuilder() {
						{
							user(InitialDataSetup.this.user);
							department(InitialDataSetup.this.department);
							staff("STF".concat("/").concat(org.joda.time.format.DateTimeFormat.forPattern("yyyy").print(new DateTime(DateTime.now()))).concat("/").concat(InitialDataSetup.this.department.getCode()).concat("/").concat(InitialDataSetup.this.user.getId().toString()), 
									ApplicationConstant.ACTIVE_STATUS, Utils.getTitles().get("DR"), Utils.randomString(30), Boolean.FALSE, Boolean.TRUE);
						}
					}.build();
				}
				
				//Student
				{
					InitialDataSetup.this.student = new StudentBuilder() {
						{
							user(InitialDataSetup.this.user);
							programme(InitialDataSetup.this.studyProgramme);
							department(InitialDataSetup.this.department);
							student("STD".concat("/").concat(org.joda.time.format.DateTimeFormat.forPattern("yyyy").print(new DateTime(DateTime.now()))).concat("/").concat(InitialDataSetup.this.department.getCode()).concat("/").concat(InitialDataSetup.this.user.getId().toString()), 
									Utils.getEndReasons().get("R1"), null, "in view", Boolean.TRUE, Utils.getPartTypes().get("OC"), Utils.getEnrolmentTypes().get("OF"), Utils.randomString(30), ApplicationConstant.PENDING_STATUS, 
									new DateTime(DateTime.now()), new DateTime(DateTime.now()), InitialDataSetup.this.studyProgramme.getEndDate());
						}
					}.build();
				}
				
				//Course
				{
					InitialDataSetup.this.course = new CourseBuilder() {
						{
							user(InitialDataSetup.this.user, InitialDataSetup.this.user);
							staff(InitialDataSetup.this.staff);
							programme(InitialDataSetup.this.studyProgramme);
							semester(InitialDataSetup.this.academiSemester);
							course("General Mathematics I", ApplicationConstant.ACTIVE_STATUS, "MTH 110.1", "General Mathematics", Utils.getOptionalities().get("MA"), 100, 3.0, 
									new DateTime(DateTime.now()), new DateTime(DateTime.now()));
						}
					}.build();
					
					new CourseBuilder() {
						{
							user(InitialDataSetup.this.user, InitialDataSetup.this.user);
							staff(InitialDataSetup.this.staff);
							programme(InitialDataSetup.this.studyProgramme);
							semester(InitialDataSetup.this.academiSemester);
							course("Calculus I", ApplicationConstant.ACTIVE_STATUS, "MTH 120.1", "Calculus", Utils.getOptionalities().get("MA"), 100, 3.0, 
									new DateTime(DateTime.now()), new DateTime(DateTime.now()));
						}
					}.build();
					
					new CourseBuilder() {
						{
							user(InitialDataSetup.this.user, InitialDataSetup.this.user);
							staff(InitialDataSetup.this.staff);
							programme(InitialDataSetup.this.studyProgramme);
							semester(InitialDataSetup.this.academiSemester);
							course("General Studies: English Language", ApplicationConstant.ACTIVE_STATUS, "GES 100.1", "English Language", Utils.getOptionalities().get("MA"), 100, 3.0, 
									new DateTime(DateTime.now()), new DateTime(DateTime.now()));
						}
					}.build();
				}
				return null;
			}
			
			private Boolean dataIsAlreadyPresent() {
				return InitialDataSetup.this.em.createQuery("select count(u.id) from User u", Long.class).getSingleResult().longValue() > 0;
			}
		});
		EntityBuilderManager.clearEntityManager();
	}
	
}
