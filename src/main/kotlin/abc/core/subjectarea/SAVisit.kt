package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAVisit:Entity{
    var SAEvent:EntityLink<SAEvent> = EntityLink<SAEvent>()
    var date:OwnDateTime=OwnDateTime()
    var student:EntityLink<SAStudent> = EntityLink<SAStudent>()
    constructor() {}
}
