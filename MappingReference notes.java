
((((((((((((((((((((((((((((((((((((ONETOONE MAPPING))))))))))))))))))))))))))))))))))))) 
------------------------------------
Customer.class
------------------------------------
@Entity
public class Customer {   //we have to jsondata for this class
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;   private String customerName; private String customerEmail; 
    private Long customerPh;
	@OneToOne(/*targetEntity = Order.class,*/cascade=CascadeType.ALL)
	@JoinColumn(name="order_Idfk",referencedColumnName="Id1")
	private Order1 orderId;
------------------------------------
Order1.class
------------------------------------
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;    private String customerName;   private String customerEmail; 
    private Long customerPh;
	@OneToOne(/*targetEntity = Order.class,*/cascade=CascadeType.ALL)
	@JoinColumn(name="order_Idfk",referencedColumnName="Id1")
	private Order1 orderId;
______________________________
}____________________________________________________________________________________________________________________________________________-
((((((((((((((((((((((((((((((((((((ONETOMANY MAPPING)))))))))))))))))))))))))))))))))))))
--------------------
Customer.class
--------------------- 
@Entity
public class Customer {    //we have to pass jsondata for this class
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId; private String customerName; private String customerEmail;
	private Long customerPh;
	@OneToMany(mappedBy="cust1")
	private List<Order1> orderId;
}
------------------------------
Order1.class
----------------------------
@Entity
public class Order1 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id1;  private String orderDesc;
	@ManyToOne
	private  Customer cust1;
}
-------------
json.data
---------------
{
    "customerId":1,
"customerName":"Krishnaveni Konda",
"customerEmail":"kondakrishnaveni47@gmail.com",
"customerPh":7578648,
"orderId":[
    {"orderDesc":"specialoffer",
    "orderId":1},
    {"orderDesc":"wholesale",
    "orderId":2}
]
}
___________________________________________________________________________________________________________________________________________________________________________________________________________
(((((((((((((((((((((((((((((((((((((((((((MANYTOMANY)))))))))))))))))))))))))))))))))))))))))))
------------------------
Customer.class
-------------------------
@Entity
public class Customer {    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	private String customerName;
	
	private String customerEmail;
	
	private Long customerPh;

	
	@ManyToMany(mappedBy="cust1")
	private List<Order1> orderId;
}
-------------------------
Order1.class
-------------------------
@Entity
public class Order1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id1;
	
	private String orderDesc;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="oreder1_cust",
    @JoinColumns=@JoinColumn(name="parentasOrder1.Id1",referencedColumnName="Id1"),
    inverseJoinColumns(name="custid",referenceColumnName="customerId"))
	private  List<Customer> cust1;
}





