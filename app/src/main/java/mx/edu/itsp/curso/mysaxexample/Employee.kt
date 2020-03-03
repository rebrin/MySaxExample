package mx.edu.itsp.curso.mysaxexample

class Employee(var id:Int ,var age:Int,var name:String, var gender:String,var role:String){
    override fun toString(): String {
        return "ID:${id}, empleado:${name}, edad:${age}, genero:${gender}, rol:${role}"
    }
}