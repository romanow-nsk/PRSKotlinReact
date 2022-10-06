package abc.core.subjectarea

import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RestAPIBase (var ip: String = "127.0.0.1", var port: Int = 4567){
    suspend fun shutdown(SessionToken:String,pass:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/shutdown?pass="+pass+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun lock(SessionToken:String,pass:String,on:Boolean) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/lock?pass="+pass+"&on="+on+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun update(SessionToken:String,artId:Long) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/file/update?artId="+artId+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun execute(SessionToken:String,pass:String,cmd:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/execute?pass="+pass+"&cmd="+cmd+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun getConstByGroups(SessionToken:String) : ArrayList<ArrayList<ConstValue>> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/const/bygroups",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArrayList<ArrayList<ConstValue>>>(response)
        }
    suspend fun getConstAll(SessionToken:String) : ArrayList<ConstValue> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/const/all",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArrayList<ConstValue>>(response)
        }
    suspend fun login() : User {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/login",RequestInit("post"))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<User>(response)
        }
    suspend fun login(phone:String,pass:String) : User {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/login/phone?phone="+phone+"&pass="+pass+"",RequestInit("get"))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<User>(response)
        }
    suspend fun deploy(SessionToken:String,pass:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/deploy?pass="+pass+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun updateEntity(SessionToken:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/update",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun workSettings(SessionToken:String) : DBRequest {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<DBRequest>(response)
        }
    suspend fun getEntity(SessionToken:String,classname:String,id:Long,level:Int) : DBRequest {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/get?classname="+classname+"&id="+id+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<DBRequest>(response)
        }
    suspend fun getEntityList(SessionToken:String,classname:String,mode:Int,level:Int) : ArrayList<DBRequest> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/list?classname="+classname+"&mode="+mode+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArrayList<DBRequest>>(response)
        }
    suspend fun addEntity(SessionToken:String,level:Int) : JLong {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/add?level="+level+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JLong>(response)
        }
    suspend fun clearTable(SessionToken:String,table:String,pass:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/cleartable?table="+table+"&pass="+pass+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun exportDBxls(SessionToken:String) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/exportdb",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun rebootServer(SessionToken:String,pass:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/reboot?pass="+pass+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun prepareDB(SessionToken:String,operation:Int,pass:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/preparedb?operation="+operation+"&pass="+pass+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun getFolder(SessionToken:String,pass:String,folder:String) : StringList {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/files/list?pass="+pass+"&folder="+folder+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<StringList>(response)
        }
    suspend fun keepalive(SessionToken:String) : JInt {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/keepalive",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JInt>(response)
        }
    suspend fun getEntityNumber(SessionToken:String,classname:String) : JInt {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/number?classname="+classname+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JInt>(response)
        }
    suspend fun sendBug(SessionToken:String) : JLong {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/bug/add",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JLong>(response)
        }
    suspend fun ping() : JEmpty {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/debug/ping",RequestInit("get"))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun restore(SessionToken:String,pass:String,id:Long) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/restore?pass="+pass+"&id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun removeEntity(SessionToken:String,classname:String,id:Long) : JBoolean {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/remove?classname="+classname+"&id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JBoolean>(response)
        }
    suspend fun getConsoleLog(SessionToken:String,count:Int) : StringList {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/debug/consolelog?count="+count+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<StringList>(response)
        }
    suspend fun getBugList(SessionToken:String,mode:Int) : EntityList<BugMessage> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/bug/list?mode="+mode+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<EntityList<BugMessage>>(response)
        }
    suspend fun exportDBxlsx(SessionToken:String,xlsx:Boolean,blocksize:Int) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/exportdb?xlsx="+xlsx+"&blocksize="+blocksize+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun dump(SessionToken:String) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/dump",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun longPolling(SessionToken:String,pass:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/longpoll?pass="+pass+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun serverState(SessionToken:String) : ServerState {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/serverstate",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ServerState>(response)
        }
    suspend fun deleteById(SessionToken:String,entity:String,id:Long) : JBoolean {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/delete?entity="+entity+"&id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JBoolean>(response)
        }
    suspend fun undeleteById(SessionToken:String,entity:String,id:Long) : JBoolean {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/undelete?entity="+entity+"&id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JBoolean>(response)
        }
    suspend fun setAddressGPS(SessionToken:String,id:Long) : JLong {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/address/setgps?id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JLong>(response)
        }
    suspend fun importDBxls(SessionToken:String,pass:String,id:Long) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/importdb?pass="+pass+"&id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun getGPSByAddress(SessionToken:String) : GPSPoint {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/gps/address",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<GPSPoint>(response)
        }
    suspend fun getUserList(SessionToken:String,mode:Int,level:Int) : EntityList<User> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/list?mode="+mode+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<EntityList<User>>(response)
        }
    suspend fun addUser(SessionToken:String) : JLong {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/add",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JLong>(response)
        }
    suspend fun testCall(SessionToken:String,operation:Int,value:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/testcall?operation="+operation+"&value="+value+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun debugToken(pass:String) : JString {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/debug/token?pass="+pass+"",RequestInit("get"))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun deployMB(SessionToken:String,pass:String,mb:Int) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/deploy?pass="+pass+"&mb="+mb+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun clearDB(SessionToken:String,pass:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/cleardb?pass="+pass+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun setCashMode(SessionToken:String,mode:Boolean,pass:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/cashmode?mode="+mode+"&pass="+pass+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun updateUser(SessionToken:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/update",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun reopenLogFile(SessionToken:String,pass:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/admin/logfile/reopen?pass="+pass+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun getBug(SessionToken:String,id:Long) : BugMessage {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/bug/get?id="+id+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<BugMessage>(response)
        }
    suspend fun logoff(SessionToken:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/logoff",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun currentVersion(SessionToken:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/version",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun removeNotification(SessionToken:String,id:Long) : JBoolean {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/remove?id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JBoolean>(response)
        }
    suspend fun getNotificationList(SessionToken:String) : EntityList<NTMessage> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/list",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<EntityList<NTMessage>>(response)
        }
    suspend fun updateNotification(SessionToken:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/update",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun addNotificationBroadcast(SessionToken:String) : JInt {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/add/broadcast",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JInt>(response)
        }
    suspend fun getSetverEnvironment(SessionToken:String) : ArrayList<String> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/server/environment",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArrayList<String>>(response)
        }
    suspend fun getArtifactConditionList(SessionToken:String,type:Int,owner:String,namemask:String,filenamemask:String,size1:Long,size2:Long,dateInMS1:Long,dateInMS2:Long) : ArtifactList {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/condition/list?type="+type+"&owner="+owner+"&namemask="+namemask+"&filenamemask="+filenamemask+"&size1="+size1+"&size2="+size2+"&dateInMS1="+dateInMS1+"&dateInMS2="+dateInMS2+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArtifactList>(response)
        }
    suspend fun getEntityListWithPaths(SessionToken:String,classname:String,mode:Int,level:Int,paths:String) : ArrayList<DBRequest> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/list/withpaths?classname="+classname+"&mode="+mode+"&level="+level+"&paths="+paths+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArrayList<DBRequest>>(response)
        }
    suspend fun createArtifactFromString(SessionToken:String,fileName:String,text:String) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/fromstring?fileName="+fileName+"&text="+text+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun setNotificationState(SessionToken:String,id:Long,state:Int) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/setstate?id="+id+"&state="+state+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun getNamesByPattern(SessionToken:String,entity:String,pattern:String) : EntityList<EntityNamed> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/names/get?entity="+entity+"&pattern="+pattern+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<EntityList<EntityNamed>>(response)
        }
    suspend fun getEntityWithPaths(SessionToken:String,classname:String,id:Long,level:Int,paths:String) : DBRequest {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/get/withpaths?classname="+classname+"&id="+id+"&level="+level+"&paths="+paths+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<DBRequest>(response)
        }
    suspend fun getEntityListLast(SessionToken:String,classname:String,number:Int,level:Int) : ArrayList<DBRequest> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/list/last?classname="+classname+"&number="+number+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArrayList<DBRequest>>(response)
        }
    suspend fun updateEntityField(SessionToken:String,name:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/update/field?name="+name+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun getNotificationUserList(SessionToken:String,userid:Long,usertype:Int,state:Int) : EntityList<NTMessage> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/user/list?userid="+userid+"&usertype="+usertype+"&state="+state+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<EntityList<NTMessage>>(response)
        }
    suspend fun addArtifactToList(SessionToken:String,classname:String,fieldname:String,id:Long,artifactid:Long) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/artifactlist/add?classname="+classname+"&fieldname="+fieldname+"&id="+id+"&artifactid="+artifactid+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun getNotificationCount(SessionToken:String) : JInt {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/count",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JInt>(response)
        }
    suspend fun removeArtifactFromList(SessionToken:String,classname:String,fieldname:String,id:Long,artifactid:Long) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/artifactlist/remove?classname="+classname+"&fieldname="+fieldname+"&id="+id+"&artifactid="+artifactid+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun getEntityListByQuery(SessionToken:String,classname:String,xmlquery:String,level:Int) : ArrayList<DBRequest> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/list/query?classname="+classname+"&xmlquery="+xmlquery+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArrayList<DBRequest>>(response)
        }
    suspend fun getWorkSettingsString(SessionToken:String,field:String) : JString {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings/get/string?field="+field+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JString>(response)
        }
    suspend fun getWorkSettingsBoolean(SessionToken:String,field:String) : JBoolean {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings/get/boolean?field="+field+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JBoolean>(response)
        }
    suspend fun updateWorkSettings(SessionToken:String,field:String,value:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings/update/string?field="+field+"&value="+value+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun updateWorkSettings(SessionToken:String,field:String,value:Boolean) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings/update/boolean?field="+field+"&value="+value+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun updateWorkSettings(SessionToken:String,field:String,value:Int) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings/update/int?field="+field+"&value="+value+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun updateWorkSettings(SessionToken:String) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings/update",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun getWorkSettingsInt(SessionToken:String,field:String) : JInt {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/worksettings/get/int?field="+field+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JInt>(response)
        }
    suspend fun getUserById(SessionToken:String,id:Long,level:Int) : User {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/get?id="+id+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<User>(response)
        }
    suspend fun getArtifactById(SessionToken:String,id:Long,level:Int) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/get?id="+id+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun removeArtifact(SessionToken:String,id:Long) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/remove?id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun convertArtifact(SessionToken:String,id:Long) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/convert?id="+id+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun downLoad(SessionToken:String,id:Long) : ResponseBody {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/file/load?id="+id+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ResponseBody>(response)
        }
    suspend fun getArtifactList(SessionToken:String,mode:Int,level:Int) : ArtifactList {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/list?mode="+mode+"&level="+level+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ArtifactList>(response)
        }
    suspend fun getNotification(SessionToken:String,id:Long) : NTMessage {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/get?id="+id+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<NTMessage>(response)
        }
    suspend fun createArtifact(SessionToken:String,description:String,origname:String,filesize:Long) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/create?description="+description+"&origname="+origname+"&filesize="+filesize+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun getHelpFileList(question:String) : EntityList<HelpFile> {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/helpfile/list?question="+question+"",RequestInit("get"))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<EntityList<HelpFile>>(response)
        }
    suspend fun replaceArtifact(SessionToken:String,classname:String,fieldname:String,id:Long,artifactid:Long) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/entity/artifact/replace?classname="+classname+"&fieldname="+fieldname+"&id="+id+"&artifactid="+artifactid+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun setArtifactName(SessionToken:String,id:Long,name:String) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/artifact/setname?id="+id+"&name="+name+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun upload(SessionToken:String,description:String,origname:String) : Artifact {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/file/upload?description="+description+"&origname="+origname+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun downLoad2(SessionToken:String) : ResponseBody {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/file/load2",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ResponseBody>(response)
        }
    suspend fun addNotification(SessionToken:String) : JLong {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/notification/add",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JLong>(response)
        }
    suspend fun uploadByName(SessionToken:String,fname:String,root:Boolean) : JEmpty {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/file/uploadByName?fname="+fname+"&root="+root+"",RequestInit("post",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun downLoadByName(SessionToken:String,fname:String,root:Boolean) : ResponseBody {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/file/loadByName?fname="+fname+"&root="+root+"",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<ResponseBody>(response)
        }
    suspend fun getOwnAccount(SessionToken:String) : Account {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val response = window
        .fetch("http://"+ip+":"+port+"/api/user/account/get",RequestInit("get",headers))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Account>(response)
        }
}
