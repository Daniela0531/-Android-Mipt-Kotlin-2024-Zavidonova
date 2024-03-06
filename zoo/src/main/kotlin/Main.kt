enum class AnimalType {
    FISH, HIPPOPOTAMUS, CAT, DOG, HORSE
}

class Zoo(animalsList: ArrayList<Animal>) {
    private var animals = ArrayList<Animal>()
    private var wardens = ArrayList<Warden>()

    init {
        animals = animalsList
    }

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun removeAnimal(id: Int) {
        for (curAnimal in animals) {
            if (curAnimal.id == id) {
                animals.remove(curAnimal)
                break
            }
        }
    }

    fun appointWardenForAnimal(warden: Warden, animal: Animal) {
        for (curWarden in wardens) {
            if (curWarden == warden) {
                curWarden.addAnimal(animal)
                break
            }
        }
        for (curAnimal in animals) {
            if (curAnimal == animal) {
                curAnimal.warden = warden
                break
            }
        }
    }

    fun getAllAnimalsByWarden(id: Int): ArrayList<Animal> {
        var animalsByWardens = ArrayList<Animal>()
        for (animal in animals) {
            if (animal.warden != null) {
                if (animal.warden!!.id == id) {
                    animalsByWardens.add(animal)
                }
            }
        }
        return animalsByWardens
    }

    fun getAllAnimalsByWardens(names: ArrayList<String>): ArrayList<Animal> {
        var animalsByWardens = ArrayList<Animal>()
        for (animal in animals) {
            if (animal.warden != null) {
                for (name in names) {
                    if (animal.warden!!.name == name) {
                        animalsByWardens.add(animal)
                    }
                }
            }
        }
        return animalsByWardens
    }

    fun getAllAnimalsTallerThan(height: Int): ArrayList<Animal> {
        var animalsTallerThan = ArrayList<Animal>()
        for (animal in animals) {
            if (animal.height > height) {
                animalsTallerThan.add(animal)
            }
        }
        return animalsTallerThan
    }

    fun getAllAnimalsMakingSounds(): ArrayList<Animal> {
        var animalsMakingSound = ArrayList<Animal>()
        for (animal in animals) {
            if (animal.type != AnimalType.FISH.toString()) {
                animalsMakingSound.add(animal)
            }
        }
        return animalsMakingSound
    }

    fun getAllAnimalsOfType(type: String): ArrayList<Animal> {
        var animalsOfType = ArrayList<Animal>()
        for (animal in animals) {
            if (animal.type != type) {
                animalsOfType.add(animal)
            }
        }
        return animalsOfType
    }


    class Animal(var type: String, var height: Int, var id: Int) {
        //    var sound:
        var warden: Warden? = null
    }

    class Warden(var name: String, var id: Int) {
        var animals: ArrayList<Animal> = ArrayList<Animal>()

        fun addAnimal(newAnimal: Animal) {
            animals.add(newAnimal)
        }

        fun removeAnimal(animal: Animal) {
            animals.remove(animal)
        }
    }
}