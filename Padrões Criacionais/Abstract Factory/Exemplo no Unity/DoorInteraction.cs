using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DoorInteraction : Interactable
{[Header("Pick paremetres")]
[SerializeField] private Animator anim;
[SerializeField] private Image buttonImage;
//Exibe um botão de interação
    public override void OnFocus()
    {
        buttonImage.gameObject.SetActive(true);
    }
//Abre a porta ao interagir e remove a imagem
    public override void OnInteract()
    {
        anim.SetBool("isOpen",true);
        buttonImage.gameObject.SetActive(false);
    }
//Fecha a porta ao parar de interagir e remove a imagem
    public override void OffInteract()
    {
       anim.SetBool("isOpen",false);
       buttonImage.gameObject.SetActive(false);
    }
//Ao parar de olhar remove a imagem
    public override void OnLoseFocus()
    {
        buttonImage.gameObject.SetActive(false); 
    }
}

