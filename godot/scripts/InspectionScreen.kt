@GodotScript
class InspectionScreen : Control() {

	override fun _ready() {
		println("✅ SUCCESS: Godot + Kotlin/JVM + Control root is working!")
		println("Root node class: ${this::class.simpleName}")
		println("Ready for shared ViewModel + SQLDelight persistence")
	}
}
