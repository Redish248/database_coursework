package itmo.coursework.exception

class AnimalNotFoundException(animalUid: String) :
    CourseWorkException("Animal with id $animalUid not found")