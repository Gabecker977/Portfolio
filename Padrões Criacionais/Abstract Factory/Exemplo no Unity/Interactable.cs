using UnityEngine;
public abstract class Interactable : MonoBehaviour
{
    public virtual void Awake() {
        gameObject.layer = 11;
    }
    public abstract void OnFocus();
    public abstract void OnInteract();
    public abstract void StopInteract();
    public abstract void OnLoseFocus();
}
