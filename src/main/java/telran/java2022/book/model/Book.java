package telran.java2022.book.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "isbn")
@Entity
public class Book implements Serializable{

	private static final long serialVersionUID = 7934730430500833561L;
	
	@Id
	String isbn;
	String title;
	@ManyToMany(cascade = CascadeType.ALL, targetEntity=Author.class)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Set<Author> authors;
	@ManyToOne
	Publisher publisher;

}
