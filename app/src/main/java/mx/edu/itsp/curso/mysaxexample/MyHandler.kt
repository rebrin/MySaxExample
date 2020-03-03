package mx.edu.itsp.curso.mysaxexample

import androidx.annotation.IntegerRes
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler
import java.lang.StringBuilder

class MyHandler():DefaultHandler(){
    lateinit var empList:MutableList<Employee>
    lateinit var emp: Employee
    lateinit var data:StringBuilder
    var bName:Boolean =false
    var bAge:Boolean =false
    var bGender:Boolean =false
    var bRole:Boolean =false

    override fun startElement(
        uri: String?,
        localName: String?,
        qName: String?,
        attributes: Attributes?
    ) {
        //super.startElement(uri, localName, qName, attributes)
        if(qName.equals("Employee",true)){
            var id=attributes?.getValue("id")
            var employee=Employee(Integer.parseInt(id.toString()),0,"","","")
            if(empList== null)
               empList= mutableListOf<Employee>()

            if(qName.equals("Name",true))
                bName=true
            else if(qName.equals("Age",true))
                bAge=true
            else if(qName.equals("Gender",true))
                bGender=true
            else if(qName.equals("Role",true))
                bRole=true
            //para trar los datos
            data= StringBuilder()
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        //super.endElement(uri, localName, qName)
        if(bName){
            emp.name=data.toString()
            bName=false
        }else if(bAge){
            emp.age= Integer.parseInt(data.toString())
            bAge=false
        }else if(bGender){
            emp.gender= data.toString()
            bGender=false
        }else if(bRole){
            emp.role= data.toString()
            bRole=false
        }

        if(qName.equals("Employee",true)){
            //todo añadir a la lista
            empList.add(emp)
        }
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        data.append(String(ch!!,start,length))
    }

}