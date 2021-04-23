/*
 *
 * Copyright (C)  2021  mike.education
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */

package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "thematic")
    private String thematic;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.PERSIST )
    private List<CourseGroup> courseGroupList;

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThematic() {
        return thematic;
    }

    public void setThematic(String thematic) {
        this.thematic = thematic;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<CourseGroup> getCourseGroupList() {
        return courseGroupList;
    }

    public void setCourseGroupList(List<CourseGroup> courseGroupList) {
        this.courseGroupList = courseGroupList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thematic='" + thematic + '\'' +
                ", status=" + status +
                ", courseGroupList=" + courseGroupList +
                '}';
    }
}
