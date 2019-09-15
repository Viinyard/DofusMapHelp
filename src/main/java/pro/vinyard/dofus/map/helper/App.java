package pro.vinyard.dofus.map.helper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import pro.vinyard.dofus.map.helper.control.DofusMapControler;
import pro.vinyard.dofus.map.helper.dofusmap.view.DofusMapPane;
import pro.vinyard.dofus.map.helper.model.DofusMapModel;

@SpringBootApplication
public class App extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
//		 SpringApplication.run(App.class, args);
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(App.class).headless(true).run(args);

		EventQueue.invokeLater(() -> {
			App swingApp = ctx.getBean(App.class);
			swingApp.setVisible(true);
		});
	}

	public App(String[] args) {
		this.setTitle("Dofus Helper");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setLayout(new BorderLayout());
		
		DofusMapModel model = new DofusMapModel();
		DofusMapControler ctrl = new DofusMapControler(model);
		DofusMapPane view = new DofusMapPane(model);
		
		view.addHintListener(ctrl);
		view.addDirectionListener(ctrl);
		view.addPositionListener(ctrl);
		view.addActionListener(ctrl);
		
		this.add(view, BorderLayout.CENTER);

		this.pack();
	}
}