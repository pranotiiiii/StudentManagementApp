<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
	<style>
    body {
        background-image: url("images/bg.jpg");
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        min-height: 100vh;
    }

    .shiftBatch {
        background-color: rgba(255, 255, 255, 0.85);
        border-radius: 10px;
    }
</style>
	
</head>


   
    <body >
	<div class="d-flex justify-content-center align-center"> 
 
  <div class="w-50 align-middle border border-info  border-3 mt-2" 
   style="height: 500px"> 
   <h6 class="p-3 text-primary "> 
    <u>Student Details :-</u> 
   </h6> 
 	<div class="shiftBatch">
   <div class="border border-secondary m-3 p-2"> 
    
      <table class="table table-hover border border-secondary "> 
      <tbody> 
         <tr class="table-primary fs-6"> 
           <th>Student Id</th> 
           <td>${st.studentId}</td> 
         </tr> 
           <tr class="table-primary fs-6"> 
           <th>Student Name</th> 
           <td>${st.studentFullName}</td> 
        
           <tr class="table-primary fs-6"> 
           <th>Course Name</th> 
           <td>${st.studentCourse}</td> 
         </tr> 
       
           <tr class="table-primary fs-6"> 
           <th>Batch Number</th> 
           <td>${st.batchNumber}</td> 
         </tr> 
           </tr> 
           <tr class="table-danger fs-6"> 
           <th>Fees Paid</th> 
           <td>${st.feesPaid}</td> 
         </tr> 
          
      </tbody> 
      </table> 
   
        <form action="changeBatch"> 
        <input type="hidden" name="studentId" value="${st.studentId}">
        <div class="bg-dark p-2  d-flex justify-content-between"> 
        <label for="amount" class="text-info"><b>Select Batch<br> 
		</b></label>
			
			<select class="select form-control-sm border border-primary" name="batchNumber"> 
                    <option value="#" slected>Select Batch Number</option> 
												<option value="FDJ-160">FDJ-160</option>
												<option value="REG-199">REG-199</option>
												<option value="FDJ-199">FDJ-199</option>
												<option value="REG-162">REG-162</option>
                  </select>  
        
        </div> 
         <div class="d-flex justify-content-center pt-5"> 
        <button class="btn btn-success btn-sm ">Shift Batch</button> 
        </div> 
        
        </form> 
   		</div>
     </div> 
  </div> 
 
 
 
 </div> 
</body>
</html>