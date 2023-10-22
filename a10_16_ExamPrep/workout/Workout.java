package a10_16_ExamPrep.workout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {

        Exercise exercise = this.exercises.stream().
                filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);

        return this.exercises.remove(exercise);
    }

    public Exercise getExercise(String name, String muscle) {

        Exercise exercise = this.exercises.stream().
                filter(e -> e.getName().equals(name) &&
                        e.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);

        return exercise;
    }

    public Exercise getMostBurnedCaloriesExercise(){

        List<Exercise> exercisesSortedByCalories = this.exercises.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getBurnedCalories(), e1.getBurnedCalories()))
                .collect(Collectors.toList());

        return exercisesSortedByCalories.get(0);
    }

    public int getExerciseCount(){
        return exercises.size();
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(this.type);
        for(Exercise e : exercises ){
            sb.append(System.lineSeparator()).append(e);
        }

        return sb.toString().trim();
    }


}
