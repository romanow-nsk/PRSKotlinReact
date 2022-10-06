package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAEduUnit:Entity{
    var SADiscipline:EntityLink<SADiscipline> = EntityLink<SADiscipline>()
    var basePoint:Int=0
    var unitType:Int=0
    var orderNum:Int=0
    var manualPointSet:Boolean=false
    var deliveryWeek:Int=0
    var name:String=""
    var comment:String=""
    constructor() {}
}
