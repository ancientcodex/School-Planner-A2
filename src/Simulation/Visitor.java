package Simulation;

import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Visitor {
	private Point2D position;
	private double angle;

	private double speed = 5;
	private BufferedImage image;
	double frameTime = 0.1;
	int frame = 0;
	private Point2D target;


	public Visitor(Point2D position)
	{
		this.position = position;
		this.angle = 0;
		try {
			image = ImageIO.read(this.getClass().getResource("/visitor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.speed += Math.random();
		this.angle = Math.random()*2*Math.PI;

		this.target = new Point2D.Double(400,400);
	}

	public boolean hasCollision() throws IOException, ParseException {

		ArrayList<Integer> layerData = new ArrayList<>(new Tileset().getLayerData(5, 6));
		for (int x = 0; x < 100-1; x++) {
			for (int y = 0; y < 100-1; y++) {
				if (!(layerData.get(x  * 100 + y) == 0)) {
					Area currBlock = new Area(new Rectangle2D.Double(x*32, y*32, 32,32));
					if (currBlock.contains(this.position)) {
						return true;
					}
				}
			}
		}

		return false;
	}


	public void update(ArrayList<Visitor> visitors, double deltaTime)
	{
		Point2D newPosition = new Point2D.Double(this.position.getX() + this.speed * Math.cos(angle),
				this.position.getY() + this.speed * Math.sin(angle));


		boolean hasCollision = false;
		for(Visitor visitor : visitors)
		{
			if(visitor != this && visitor.hasCollision(newPosition))
			{
				hasCollision = true;
				break;
			}
		}

		if(!hasCollision)
		{
			this.position = newPosition;
		}
		else
		{
			this.angle += 0.2;
		}




		Point2D diff = new Point2D.Double(target.getX() - this.position.getX(), target.getY() - this.position.getY());
		double targetAngle = Math.atan2(diff.getY(), diff.getX());

		double angleDiff = targetAngle - angle;
		while(angleDiff > Math.PI)
			angleDiff -= 2 * Math.PI;
		while(angleDiff < -Math.PI)
			angleDiff += 2 * Math.PI;

		if(angleDiff < -0.1)
			angle-=0.1;
		else if(angleDiff > 0.1)
			angle+=0.1;
		else
			this.angle = targetAngle;

		frameTime -= deltaTime;
		if(frameTime < 0)
		{
			frameTime = 1/30.0;
			frame = (frame+1)%8;
		}

	}


	public void draw(Graphics2D g)
	{
		AffineTransform tx = new AffineTransform();
		tx.translate(position.getX()-32, position.getY()-32);
		tx.rotate(angle, 32, 32);

		g.drawImage(image, tx, null);

		g.draw(new Ellipse2D.Double(position.getX()-16, position.getY()-16,32,32));

	}


	public boolean hasCollision(Visitor otherVisitor)
	{
		return otherVisitor.position.distance(position) < 64;
	}
	public boolean hasCollision(Point2D otherPosition)
	{
		return otherPosition.distance(position) < 64;
	}


	public void setTarget(Point2D target) {
		this.target = target;
	}
}