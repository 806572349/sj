package com.nemo.sj.common

/**
 *  create by Nemo
 *  2018/7/9  23:15
 */
class JsonData {

    var  ret:Boolean=false;

    var msg:String="";

    var data:Any="";

    fun toMap():Map<String,Any>{
        val map = hashMapOf<String, Any>()
        map["ret"]=ret
        map["msg"]=msg
        map["data"]=data
        return  map
    }
    //静态方法  伴生
    companion object {
        fun success(data:Any,msg: String):JsonData{
         return JsonData().apply {
                ret=true
                this.msg=msg
                this.data=data
            }
        }

        fun fail(data: Any):JsonData{
            return JsonData().apply {
                ret=false
                this.msg=msg
                this.data=data
            }
        }

        fun fail(data: Any,msg:String):JsonData{
            return JsonData().apply {
                ret=false
                this.msg=msg
                this.data=data
            }
        }

        fun success(msg: String):JsonData{
            return JsonData().apply {
                ret=true
                this.msg=msg
                this.data=data
            }
        }

    }


}