import java.io.File
import java.util.Random

fun main(args: Array<String>) {
    val rn = Random()
    if (args.contains("-h") || args.contains("--help")) {
        println("Usage:\n   rfp <path to file> returns random file from folder")
        return
    } else if (args.size > 1 || args.size == 0) {
        println("Usage:\n   rfp <path to file> returns random file from folder")
        return
    } 
    try {
        val path = args[0]
        val dir = File(path)
        if (!dir.exists() || !dir.isDirectory) {
            println("Path doesn't exist or isn't a directory")
            return
        }
        val files = dir.listFiles()
        lateinit var pickedFile: File
        do {
            pickedFile = files[rn.nextInt(files.size)]
        } while (!pickedFile.isFile() || !pickedFile.exists() || pickedFile.toString().endsWith("~") )
        println(pickedFile)
    } catch (e: Exception){
        println("Something went wrong: " + e.printStackTrace())
    }
}