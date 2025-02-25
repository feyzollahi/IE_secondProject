package User;


import Project.Project;
import Skill.ProjectSkill;
import Skill.UserSkill;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class User {
    public User(JSONObject jsonObject) {
        this.isLogin = false;
        this.bio = (String) jsonObject.get("bio");
        this.firstName = (String) jsonObject.get("firstName");
        this.lastName = (String) jsonObject.get("lastName");
        this.id = (String) jsonObject.get("id");
        this.jobTitle = (String) jsonObject.get("jobTitle");
        this.bio = (String) jsonObject.get("bio");
        this.skills = new HashMap<String, UserSkill>();
        JSONArray skills;
        skills = (JSONArray) jsonObject.get("skills");
        for (Object skill1 : skills) {
            UserSkill skill = new UserSkill((JSONObject) skill1);
            this.skills.put(skill.getName(), skill);
        }
    }
    private boolean isLogin;
    private String bio;
    private String firstName;
    private String lastName;
    private String id;
    private String jobTitle;
    private String profilePictureURLText;
    private HashMap<String, UserSkill> skills;

    public boolean isUserApproprateForProject(Project project){
        for(ProjectSkill projectSkill:project.getSkills()){
            if(this.skills.get(projectSkill.getName()) == null
            || this.skills.get(projectSkill.getName()).tempGetEndorsedCount() < projectSkill.getPoint()){
                return false;
            }
        }
        return true;
    }
    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void login(){
        isLogin = true;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getProfilePictureURLText() {
        return profilePictureURLText;
    }

    public void setProfilePictureURLText(String profilePictureURLText) {
        this.profilePictureURLText = profilePictureURLText;
    }

    public HashMap<String, UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, UserSkill> skills) {
        this.skills = skills;
    }

    public void addSkill(UserSkill skill){
        this.skills.put(skill.getName(), skill);
    }
}
