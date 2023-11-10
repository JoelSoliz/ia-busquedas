/**
 * Write a description of class WaterJug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterJug
{
    private int maxContent;
    private int content;

    public WaterJug(int maxContent) {
        this.maxContent = maxContent;
        this.content = 0;
    }

    public void empty() {
        this.content = 0;
    }

    public void fill() {
        this.content = this.maxContent;
    }

    public void fillWithJug(WaterJug jug) {
        if (this.content + jug.content >= this.maxContent) {
            jug.content -= this.maxContent - this.content;
            this.content = this.maxContent;
        } else {
            this.content += jug.content;
            jug.content = 0;
        }
    }
    
    public int getContent() {
        return content;
    }
    
    public int getMaxContent() {
        return maxContent;
    }
    
    private void setContent(int newContent) {
        content = newContent > maxContent ? content : newContent;
    }
    
    public WaterJug copy() {
        WaterJug jug = new WaterJug(maxContent);
        jug.setContent(content);
        return jug;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        WaterJug other = (WaterJug) obj;
        return this.content == other.content && this.maxContent == other.maxContent;
    }

    @Override
    public String toString() {
        return "Jarron(" + this.maxContent + ") content: " + this.content;
    }
}
