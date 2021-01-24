package ru.job4j.stream;

public class Resume {
    private String name;
    private boolean education;
    private String profession;
    private int experience;
    private String phone;
    private String address;
    private int priority;

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", education=" + education +
                ", profession='" + profession + '\'' +
                ", experience=" + experience +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", priority=" + priority +
                '}';
    }

    static class Builder {
        private String name;
        private boolean education;
        private String profession;
        private int experience;
        private String phone;
        private String address;
        private int priority;

        Builder buildName(String name) {
        this.name = name;
        return this;
        }

        Builder buildEducation(boolean education) {
        this.education = education;
        return this;
        }

        Builder buildProfession(String profession) {
        this.profession = profession;
        return this;
        }

        Builder buildExperience(int experience) {
        this.experience = experience;
        return this;
        }

        Builder buildPhone(String phone) {
        this.phone = phone;
        return this;
        }

        Builder buildAddress(String address) {
        this.address = address;
        return this;
        }

        Builder buildPriority(int priority) {
        this.priority = priority;
        return this;
        }

        Resume build() {
            Resume resume = new Resume();
            resume.name = name;
            resume.education = education;
            resume.profession = profession;
            resume.experience = experience;
            resume.phone = phone;
            resume.address = address;
            resume.priority = priority;
            return resume;
        }
    }

    public static void main(String[] args) {
        Resume resume = new Builder().buildName("Ruslan")
                .buildEducation(true)
                .buildProfession("programmer")
                .buildExperience(5)
                .buildPhone("89056123546")
                .buildAddress("NN, Kominterna, 139, 4")
                .buildPriority(1)
                .build();
        System.out.println(resume);
    }
}
