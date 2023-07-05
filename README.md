# Employee - Address Assignment

## Framework used
SpringBoot

## Data flow
Data flow from Controller  >> Service >> Repository >> DataBase >> table, tables created from Models

## Controller

Created two controller </br>
1.EmployeeController </br>
-->POST method for saving employee details</br>
-->PUT method for updating</br>
-->Delete method for deleting</br>
-->GET method for getting employee details</br>

2.AddressController</br>
-->POST method for saving Address details</br>
-->PUT method for updating</br>
-->Delete method for deleting</br>
-->GET method for getting Address details</br>

## Service
Service consist of bussiness logic
for update employee details

```
public String updateEmployee(Long id, Employee employee) {
		Employee oldEmployee = getEmployeeById(id);
		if (oldEmployee != null) {
			if (employee.getAddress() != null) {
				if (employee.getAddress().getCity() != null)
					oldEmployee.getAddress().setCity(employee.getAddress().getCity());
				if (employee.getAddress().getStreet() != null)
					oldEmployee.getAddress().setStreet(employee.getAddress().getStreet());
				if (employee.getAddress().getState() != null)
					oldEmployee.getAddress().setState(employee.getAddress().getState());
				if (employee.getAddress().getZipcode() != null)
					oldEmployee.getAddress().setZipcode(employee.getAddress().getZipcode());
			}
			if (employee.getFirstName() != null)
				oldEmployee.setFirstName(employee.getFirstName());
			if (employee.getLastName() != null)
				oldEmployee.setLastName(employee.getLastName());
			employeeRepository.save(oldEmployee);
			return "Updated";
		}
		return "Employee not found";
	}
```

## Repository
connects to CRUD repository provide some default method they are</br>
1.save(entity)</br>
2.findAll()</br>
3.findById(Long id)</br>
4.delete(entity)</br>
5.deleteById(Long id) ...etc</br>
## Models
creates tables in database by using annotation @Entity</br>
In this project Model consists of two tables</br>
1.Employee Table (Dependent) -- which consist of foreign key and primary key</br>
2.Address Table (Reference) -- which only consist of primary key</br>

#### Employee Class

```
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String FirstName;
	private String lastName;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
}
```
#### Address Class

```
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String city;
	private String state;
	private String zipcode;
}