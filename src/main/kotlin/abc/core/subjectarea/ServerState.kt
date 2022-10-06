package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class ServerState:Entity{
    var serverRun:Boolean=false
    var lastMailNumber:Int=0
    var asteriskMailOn:Boolean=false
    var asrteiskDialOn:Boolean=false
    var locked:Boolean=false
    var requestNum:Int=0
    var sessionCount:Int=0
    var timeSum:Long=0
    var timeMin:Long=0
    var timeMax:Long=0
    var timeCount:Long=0
    var pid:Long=0
    var releaseNumber:Int=0
    var totalGetCount:Int=0
    var cashGetCount:Int=0
    var сashEnabled:Boolean=false
    constructor() {}
}
