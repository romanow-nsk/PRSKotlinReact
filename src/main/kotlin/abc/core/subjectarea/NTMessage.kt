package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class NTMessage:Entity{
    var user:EntityLink<User> = EntityLink<User>()
    var artifact:EntityLink<Artifact> = EntityLink<Artifact>()
    var message:String=""
    var header:String=""
    var userSenderType:Int=0
    var userReceiverType:Int=0
    var param:Long=0
    var entityName:String=""
    var sndTime:OwnDateTime=OwnDateTime()
    var recTime:OwnDateTime=OwnDateTime()
    var executeMode:Int=0
    var state:Int=0
    var type:Int=0
    constructor() {}
}
